package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MapExamples {
    private static Flux<String> testFluxMap() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.map(String::toUpperCase).log();
    }
    private static Flux<String> testFluxFlatMap() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.flatMap(MapExamples::addWord);
    }
    private static Mono<String> addWord(String string) {
        return Mono.just(String.format("%s Course", string)).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Map");
        testFluxMap().subscribe(System.out::println);
        System.out.println("Flux FlatMap");
        testFluxFlatMap().subscribe(System.out::println);
    }
}
