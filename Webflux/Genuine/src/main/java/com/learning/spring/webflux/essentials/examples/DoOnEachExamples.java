package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class DoOnEachExamples {
    private static Flux<Integer> testDoOnEach() {
        Flux<Integer> flux = Flux.range(1, 20);
        return flux.doOnEach(integerSignal -> {
            System.out.println("Signal: " + integerSignal);
            if (integerSignal.getType() == SignalType.ON_COMPLETE) {
                System.out.println("Im done!");
            }
        }).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Do On Each");
        testDoOnEach().subscribe();
    }
}
