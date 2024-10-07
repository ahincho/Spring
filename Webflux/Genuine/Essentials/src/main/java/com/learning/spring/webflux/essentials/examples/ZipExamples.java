package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;

public class ZipExamples {
    private static Flux<Tuple2<Integer, Integer>> testTuple2Zip() {
        Flux<Integer> flux1 = Flux.range(0, 10)
                .delayElements(Duration.ofMillis(500));
        Flux<Integer> flux2 = Flux.range(100, 20)
                .delayElements(Duration.ofMillis(500));
        return Flux.zip(flux1, flux2).log();
    }
    private static Flux<Tuple3<Integer, Integer, Integer>> testTuple3Zip() {
        Flux<Integer> flux1 = Flux.range(0, 15)
                .delayElements(Duration.ofMillis(250));
        Flux<Integer> flux2 = Flux.range(100, 30)
                .delayElements(Duration.ofMillis(500));
        Flux<Integer> flux3 = Flux.range(200, 45)
                .delayElements(Duration.ofMillis(750));
        return Flux.zip(flux1, flux2, flux3).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Zip with Tuple2");
        testTuple2Zip().subscribe(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Flux Zip with Tuple3");
        testTuple3Zip().subscribe(System.out::println);
        try {
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
