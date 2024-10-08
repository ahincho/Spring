package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.util.List;

public class BlockExamples {
    private static List<Integer> testBlock() {
        Flux<Integer> flux = Flux.range(1, 10).log();
        return flux.collectList().log().block();
    }
    public static void main(String[] args) {
        System.out.println("Flux Block");
        System.out.println(testBlock());
    }
}
