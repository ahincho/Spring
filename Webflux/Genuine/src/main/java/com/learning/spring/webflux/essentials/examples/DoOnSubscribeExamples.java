package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

public class DoOnSubscribeExamples {
    private static Flux<Integer> testDoOnSubscribe() {
        Flux<Integer> flux = Flux.range(1, 20);
        return flux.doOnSubscribe(subscriber -> System.out.println("Subscriber " + subscriber)).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Do On Subscribe");
        testDoOnSubscribe().subscribe(System.out::println);
    }
}
