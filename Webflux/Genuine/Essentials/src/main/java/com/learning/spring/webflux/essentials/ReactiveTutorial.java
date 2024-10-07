package com.learning.spring.webflux.essentials;

import reactor.core.publisher.Mono;

import java.util.Optional;

public class ReactiveTutorial {
    private Mono<String> testMonoJust() {
        return Mono.just("Webflux").log();
    }
    private Mono<Object> testMonoJustOrEmpty() {
        return Mono.justOrEmpty(Optional.empty()).log();
    }
    public static void main(String[] args) {
        ReactiveTutorial reactiveTutorial = new ReactiveTutorial();
        reactiveTutorial.testMonoJust().subscribe(System.out::println);
        reactiveTutorial.testMonoJustOrEmpty().subscribe(System.out::println);
    }
}
