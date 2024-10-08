package com.learning.spring.webflux.essentials.controllers.rest;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.learning.spring.webflux.essentials.models.OrderDocument;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    public OrderController(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }
    @PostMapping
    public Mono<OrderDocument> createOneOrder(@RequestBody OrderDocument orderDocument) {
        return reactiveMongoTemplate.save(orderDocument).log();
    }
    @GetMapping
    public Flux<OrderDocument> getAllOrders() {
        return reactiveMongoTemplate.findAll(OrderDocument.class).log();
    }
    @GetMapping("/{id}")
    public Mono<OrderDocument> getOneOrder(@PathVariable String id) {
        return reactiveMongoTemplate.findById(id, OrderDocument.class).log();
    }
}
