package com.learning.spring.webflux.essentials;

import reactor.core.publisher.Mono;

public class ReactiveTutorial {
    private Mono<String> testMono() {
        return Mono.just("Webflux");
    }
    public static void main(String[] args) {
        ReactiveTutorial reactiveTutorial = new ReactiveTutorial();
        reactiveTutorial.testMono().subscribe(System.out::println);
    }
}
