package com.learning.spring.webflux.essentials.pressure;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class BackPressureExamples {
    private static Flux<Long> createNoOverflowFlux() {
        return Flux.range(1, Integer.MAX_VALUE)
                .log()
                .concatMap(x -> Mono.delay(Duration.ofMillis(100)));
    }
    private static Flux<Long> createOverflowFlux() {
        return Flux.interval(Duration.ofMillis(10))
                .log()
                .concatMap(x -> Mono.delay(Duration.ofMillis(100)));
    }
    public static void main(String[] args) {
        createOverflowFlux().blockLast();
    }
}
