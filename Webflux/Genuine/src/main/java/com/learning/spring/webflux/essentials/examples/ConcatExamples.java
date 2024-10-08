package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class ConcatExamples {
    private static Flux<Integer> testConcat() {
        Flux<Integer> flux1 = Flux.range(1, 10)
                .delayElements(Duration.ofMillis(500));
        Flux<Integer> flux2 = Flux.range(100, 10)
                .delayElements(Duration.ofMillis(500));
        return Flux.concat(flux1, flux2).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Concat");
        testConcat().subscribe(System.out::println);
        try {
            Thread.sleep(7_500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
