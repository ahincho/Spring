package com.learning.spring.webflux.essentials.controllers.rest;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
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
    @GetMapping
    public Flux<CustomerDocument> getAllCustomers() {
        return this.mongoTemplate.findAll(CustomerDocument.class);
    }
    @GetMapping("/{id}")
    public Mono<CustomerDocument> getOneCustomer(@PathVariable String id) {
        return this.mongoTemplate.findById(id, CustomerDocument.class);
    }
}
