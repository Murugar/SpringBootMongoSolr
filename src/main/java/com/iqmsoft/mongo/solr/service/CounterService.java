package com.iqmsoft.mongo.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.mongo.solr.mongo.dao.CounterRepository;
import com.iqmsoft.mongo.solr.mongo.model.Counter;

@Service("counterService")
public class CounterService {
    @Autowired
    private CounterRepository counterRepository;

    public synchronized long getNextSequence() {
        Counter counter = counterRepository.findAll().get(0);
        long count = counter.getSeq() + 1;
        counter.setSeq(count);
        counterRepository.save(counter);
        return count;
    }

    public void reset() {
        counterRepository.deleteAll();
    }
}
