package com.iqmsoft.mongo.solr.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.iqmsoft.mongo.solr.mongo.model.TestDocument;

@Repository("testDocumentMongoRepository")
@SuppressWarnings("all")
@RepositoryRestResource(collectionResourceRel = "document", path = "document-mongo")
public interface TestDocumentMongoRepository extends MongoRepository<TestDocument, String> {
}
