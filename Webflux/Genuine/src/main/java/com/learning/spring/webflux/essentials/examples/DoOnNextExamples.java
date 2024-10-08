package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

public class DoOnNextExamples {
    private static Flux<Integer> testDoOnNext() {
        Flux<Integer> flux = Flux.range(1, 20);
        return flux.doOnNext(System.out::println).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Do On Next");
        testDoOnNext().subscribe();
    }
}
