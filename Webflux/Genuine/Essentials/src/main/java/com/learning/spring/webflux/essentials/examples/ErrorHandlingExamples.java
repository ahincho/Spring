package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorHandlingExamples {
    private static final Flux<Integer> flux = Flux.range(1, 10)
            .map(integer -> {
                if (integer == 3) {
                    System.out.println("Number 3 detected!");
                    throw new RuntimeException("Error: Unexpected number!");
                } else if (integer == 5) {
                    System.out.println("Number 5 detected!");
                    throw new ArithmeticException("Error: Unexpected number!");
                }
                return integer;
            });
    private static Flux<Integer> testErrorContinue() {
        return flux.onErrorContinue((throwable, o) -> System.out.println("Dont worry about: " + throwable)).log();
    }
    private static Flux<Integer> testErrorReturn() {
        return flux
                .onErrorReturn(ArithmeticException.class, -2)
                .onErrorReturn(RuntimeException.class, -1)
                .log();
    }
    private static Flux<Integer> testErrorResume() {
        return flux
                .onErrorResume(throwable -> Mono.just(-1))
                .log();
    }
    private static Flux<Integer> testErrorMap() {
        return flux
                .onErrorMap(throwable -> new UnsupportedOperationException(throwable.getMessage()))
                .log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Error Continue");
        testErrorContinue().subscribe();
        System.out.println("Flux Error Return");
        testErrorReturn().subscribe(System.out::println);
        System.out.println("Flux Error Resume");
        testErrorResume().subscribe(System.out::println);
        System.out.println("Flux Error Map");
        testErrorMap().subscribe(System.out::println);
    }
}
