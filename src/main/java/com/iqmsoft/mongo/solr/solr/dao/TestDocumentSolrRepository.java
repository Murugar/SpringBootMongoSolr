package com.iqmsoft.mongo.solr.solr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.mongo.solr.solr.model.TestSolrDocument;

@Repository("testDocumentSolrRepository")
@RepositoryRestResource(collectionResourceRel="document",path="document-solr")
public interface TestDocumentSolrRepository extends SolrCrudRepository<TestSolrDocument, String> {
    Page<TestSolrDocument> findByTitleOrBody(@Param("query")String title, @Param("query")String body, Pageable page);

}
