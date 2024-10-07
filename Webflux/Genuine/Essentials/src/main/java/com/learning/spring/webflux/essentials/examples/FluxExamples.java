package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxExamples {
    private static Flux<String> testFluxJust() {
        return Flux.just("Java", "Spring", "Spring Boot", "Spring MVC", "Spring Webflux").log();
    }
    private static Flux<String> testFluxIterables() {
        return Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Just");
        testFluxJust().subscribe(System.out::println);
        System.out.println("Flux Iterables");
        testFluxIterables().subscribe(System.out::println);
    }
}
