package com.learning.spring.webflux.essentials;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class ReactiveTutorial {
    private Mono<String> testMonoJust() {
        return Mono.just("Webflux").log();
    }
    private Mono<Object> testMonoJustOrEmpty() {
        return Mono.justOrEmpty(Optional.empty()).log();
    }
    private Mono<Object> testMonoEmpty() {
        return Mono.empty();
    }
    private Flux<String> testFluxJust() {
        return Flux.just("Java", "Spring", "Spring Boot", "Spring MVC", "Spring Webflux").log();
    }
    public static void main(String[] args) {
        ReactiveTutorial reactiveTutorial = new ReactiveTutorial();
        reactiveTutorial.testMonoJust().subscribe(System.out::println);
        reactiveTutorial.testMonoJustOrEmpty().subscribe(System.out::println);
        reactiveTutorial.testMonoEmpty().subscribe(System.out::println);
        reactiveTutorial.testFluxJust().subscribe(System.out::println);
    }
}
