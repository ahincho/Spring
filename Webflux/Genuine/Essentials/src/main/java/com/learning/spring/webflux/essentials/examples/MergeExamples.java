package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class MergeExamples {
    private static Flux<Integer> testMerge() {
        Flux<Integer> flux1 = Flux.range(1, 20)
                .delayElements(Duration.ofMillis(500));
        Flux<Integer> flux2 = Flux.range(100, 20)
                .delayElements(Duration.ofMillis(500));
        return Flux.merge(flux1, flux2).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Merge");
        testMerge().subscribe(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
