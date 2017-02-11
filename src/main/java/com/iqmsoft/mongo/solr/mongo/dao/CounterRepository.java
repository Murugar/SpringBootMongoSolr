package com.iqmsoft.mongo.solr.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.mongo.solr.mongo.model.Counter;


@Repository("counterRepository")
public interface CounterRepository extends MongoRepository<Counter, String> {

}
