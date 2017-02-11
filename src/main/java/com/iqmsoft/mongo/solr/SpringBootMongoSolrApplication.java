package com.iqmsoft.mongo.solr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootMongoSolrApplication implements CommandLineRunner {
    

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoSolrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
