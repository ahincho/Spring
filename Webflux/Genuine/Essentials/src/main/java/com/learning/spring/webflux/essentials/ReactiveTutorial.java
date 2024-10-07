package com.learning.spring.webflux.essentials;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
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
        return flux.flatMap(this::addWord);
    }
    private Mono<String> addWord(String string) {
        return Mono.just(String.format("%s Course", string)).log();
    }
    private Flux<String> testSkipCount() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.skip(2);
    }
    private Flux<String> testSkipDuration() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Quarkus", "Spring", "Spring Webflux", "Spring MVC"))
                .delayElements(Duration.ofSeconds(1));
        return flux.skip(Duration.ofSeconds(2)).log();
    }
    private Flux<String> testSkipLast() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Quarkus", "Spring", "Spring Webflux", "Spring MVC"));
        return flux.skipLast(2).log();
    }
    private Flux<Integer> testSkipComplex() {
        Flux<Integer> flux = Flux.range(1, 20);
        // return flux.skipWhile(integer -> integer < 10).log();
        return flux.skipUntil(integer -> integer == 30).log();
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
        System.out.println("Flux Skip");
        reactiveTutorial.testSkipCount().subscribe(System.out::println);
        System.out.println("Flux Skip Duration");
        reactiveTutorial.testSkipDuration().subscribe(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Flux Skip Last");
        reactiveTutorial.testSkipLast().subscribe(System.out::println);
        System.out.println("Flux Skip Complex");
        reactiveTutorial.testSkipComplex().subscribe(System.out::println);
    }
}
