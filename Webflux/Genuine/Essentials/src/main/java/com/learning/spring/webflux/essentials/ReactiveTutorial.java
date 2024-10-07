package com.learning.spring.webflux.essentials;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
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
    private Flux<String> testFluxIterables() {
        return Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
    }
    private Flux<String> testFluxMap() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.map(String::toUpperCase).log();
    }
    private Flux<String> testFluxFlatMap() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.flatMap(s -> Mono.just(s.toUpperCase()).log());
    }
    public static void main(String[] args) {
        ReactiveTutorial reactiveTutorial = new ReactiveTutorial();
        System.out.println("Mono Just");
        reactiveTutorial.testMonoJust().subscribe(System.out::println);
        System.out.println("Mono JustOrEmpty");
        reactiveTutorial.testMonoJustOrEmpty().subscribe(System.out::println);
        System.out.println("Mono Empty");
        reactiveTutorial.testMonoEmpty().subscribe(System.out::println);
        System.out.println("Flux Just");
        reactiveTutorial.testFluxJust().subscribe(System.out::println);
        System.out.println("Flux Iterables");
        reactiveTutorial.testFluxIterables().subscribe(System.out::println);
        System.out.println("Flux Map");
        reactiveTutorial.testFluxMap().subscribe(System.out::println);
        System.out.println("Flux FlatMap");
        reactiveTutorial.testFluxFlatMap().subscribe(System.out::println);
    }
}
