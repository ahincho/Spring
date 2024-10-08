package com.learning.spring.webflux.essentials.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@EnableReactiveMongoRepositories
public class MongoDatabaseConfiguration extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        System.out.println(getDatabaseName());
        return new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
    }
    @Override
    protected String getDatabaseName() {
        return "essentials";
    }
}
