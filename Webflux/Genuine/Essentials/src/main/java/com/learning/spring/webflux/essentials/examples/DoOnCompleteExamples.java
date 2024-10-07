package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

public class DoOnCompleteExamples {
    private static Flux<Integer> testDoOnComplete() {
        Flux<Integer> flux = Flux.range(1, 20);
        return flux.doOnComplete(() -> System.out.println("Im done!")).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Do On Complete");
        testDoOnComplete().subscribe();
    }
}
