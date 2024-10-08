package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class CollectListExamples {
    private static Mono<List<Integer>> testCollectList() {
        Flux<Integer> flux1 = Flux.range(0, 15);
        return flux1.log().collectList().log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Collect List Example");
        testCollectList().subscribe(System.out::println);
    }
}
