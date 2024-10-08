package com.learning.spring.webflux.essentials.examples;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DoOnCancelExamples {
    private static Flux<Integer> testDoOnCancel() {
        Flux<Integer> flux = Flux.range(1, 10)
                .delayElements(Duration.ofMillis(500));
        return flux.doOnCancel(() -> System.out.println("Cancelled!")).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Do On Cancel");
        Disposable disposable = testDoOnCancel().subscribe(System.out::println);
        try {
            Thread.sleep(2_500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        disposable.dispose();
    }
}
