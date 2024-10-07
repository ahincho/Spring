package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class BufferExamples {
    private static Flux<List<Integer>> testBuffer() {
        Flux<Integer> flux = Flux.range(1, 20)
                .delayElements(Duration.ofMillis(250)).log();
        return flux.buffer(3).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Buffer");
        testBuffer().subscribe(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
