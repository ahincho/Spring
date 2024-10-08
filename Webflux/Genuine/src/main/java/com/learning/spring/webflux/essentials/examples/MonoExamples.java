package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Mono;

import java.util.Optional;

public class MonoExamples {
    private static Mono<String> testMonoJust() {
        return Mono.just("Webflux").log();
    }
    private static Mono<Object> testMonoJustOrEmpty() {
        return Mono.justOrEmpty(Optional.empty()).log();
    }
    private static Mono<Object> testMonoEmpty() {
        return Mono.empty();
    }
    public static void main(String[] args) {
        System.out.println("Mono Just");
        testMonoJust().subscribe(System.out::println);
        System.out.println("Mono JustOrEmpty");
        testMonoJustOrEmpty().subscribe(System.out::println);
        System.out.println("Mono Empty");
        testMonoEmpty().subscribe(System.out::println);
    }
}
