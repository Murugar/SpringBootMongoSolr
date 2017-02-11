package com.iqmsoft.mongo.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iqmsoft.mongo.solr.mongo.dao.TestDocumentMongoRepository;
import com.iqmsoft.mongo.solr.mongo.model.TestDocument;
import com.iqmsoft.mongo.solr.solr.dao.TestDocumentSolrRepository;
import com.iqmsoft.mongo.solr.solr.model.TestSolrDocument;


@Service
public class TestDocumentService {

    @Autowired
    private TestDocumentMongoRepository testDocumentMongoRepository;

    @Autowired
    private TestDocumentSolrRepository testDocumentSolrRepository;

    @Autowired
    private CounterService counterService;

    @Value("${mongo.document.address}")
    private String serverAddress;

    public void indexMongo() {
        testDocumentSolrRepository.deleteAll();
        System.out.println("Indexing mongo data from mongo");
        for (TestDocument doc : testDocumentMongoRepository.findAll()) {
            System.out.println(doc);
            saveMongoToSolr(doc);
        }
    }

    public TestDocument saveMongo(TestDocument doc) {
        doc.setId(counterService.getNextSequence() + "");
        TestDocument testDocument = testDocumentMongoRepository.save(doc);
        return testDocument;
    }

    public TestSolrDocument saveMongoAndIndex(TestDocument doc) {
        return saveMongoToSolr(saveMongo(doc));
    }

    public TestSolrDocument saveMongoToSolr(TestDocument doc) {
        TestSolrDocument sDoc = new TestSolrDocument();
        sDoc.setBody(doc.getBody());
        sDoc.setTitle(doc.getTitle());
        sDoc.setId(doc.getId());
        sDoc.setDocId(Long.parseLong(doc.getId()));
        sDoc.setUrl(String.format("%s/document-mongo/", serverAddress) + doc.getId());
        return testDocumentSolrRepository.save(sDoc);
    }

    public void clear() {
        counterService.reset();
        testDocumentMongoRepository.deleteAll();
        testDocumentSolrRepository.deleteAll();
    }

}
