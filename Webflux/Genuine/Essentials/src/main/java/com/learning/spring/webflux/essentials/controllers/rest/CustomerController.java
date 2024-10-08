package com.learning.spring.webflux.essentials.controllers.rest;

import com.learning.spring.webflux.essentials.models.OrderDocument;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.learning.spring.webflux.essentials.models.CustomerDocument;
import reactor.util.function.Tuple2;

import java.util.Map;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    public CustomerController(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }
    @PostMapping
    public Mono<CustomerDocument> createOneCustomer(@RequestBody CustomerDocument customerDocument) {
        return this.reactiveMongoTemplate.save(customerDocument).log();
    }
    @GetMapping
    public Flux<CustomerDocument> getAllCustomers() {
        return this.reactiveMongoTemplate.findAll(CustomerDocument.class).log();
    }
    @GetMapping("/{id}")
    public Mono<CustomerDocument> getOneCustomer(@PathVariable String id) {
        return this.reactiveMongoTemplate.findById(id, CustomerDocument.class).log();
    }
    @GetMapping("/summaries")
    public Mono<Map<String, Double>> getCustomersSummaries() {
        return this.reactiveMongoTemplate
                .findAll(CustomerDocument.class)
                .log()
                .flatMap(customerDocument -> Mono.zip(Mono.just(customerDocument), calculateCustomerSummary(customerDocument.getId())))
                .log()
                .collectMap(tuple2 -> tuple2.getT1().getName(), Tuple2::getT2)
                .log();
    }
    private Mono<Double> calculateCustomerSummary(String customerId) {
        Criteria criteria = Criteria.where("customerId").is(customerId);
        return reactiveMongoTemplate
                .find(Query.query(criteria), OrderDocument.class)
                .log()
                .map(OrderDocument::getTotalAmount)
                .log()
                .reduce(0.0, Double::sum)
                .log();
    }
}
