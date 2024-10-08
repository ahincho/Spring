package com.learning.spring.webflux.essentials.controllers.rest;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import com.learning.spring.webflux.essentials.models.CustomerDocument;

@RestController
@RequestMapping("api/v1/customers")
public class DataController {
    private final ReactiveMongoTemplate mongoTemplate;
    public DataController(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @PostMapping
    public Mono<CustomerDocument> createOneCustomer(@RequestBody CustomerDocument customerDocument) {
        return this.mongoTemplate.save(customerDocument);
    }
}
