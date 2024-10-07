package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class CollectMapExamples {
    private static Mono<Map<Integer, Double>> testCollectMap() {
        Flux<Integer> flux = Flux.range(1, 10);
        return flux.collectMap(integer -> integer, integer -> Math.pow(integer, 2.0));
    }
    public static void main(String[] args) {
        System.out.println("Flux Collect Map");
        testCollectMap().subscribe(System.out::println);
    }
}
