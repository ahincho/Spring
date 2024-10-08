package com.learning.spring.webflux.essentials.examples;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class SkipExamples {
    private static Flux<String> testSkipCount() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Spring", "Spring Webflux")).log();
        return flux.skip(2);
    }
    private static Flux<String> testSkipDuration() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Quarkus", "Spring", "Spring Webflux", "Spring MVC"))
                .delayElements(Duration.ofSeconds(1));
        return flux.skip(Duration.ofSeconds(2)).log();
    }
    private static Flux<String> testSkipLast() {
        Flux<String> flux = Flux.fromIterable(List.of("Java", "Quarkus", "Spring", "Spring Webflux", "Spring MVC"));
        return flux.skipLast(2).log();
    }
    private static Flux<Integer> testSkipComplex() {
        Flux<Integer> flux = Flux.range(1, 40);
        // return flux.skipWhile(integer -> integer < 10).log();
        return flux.skipUntil(integer -> integer == 30).log();
    }
    public static void main(String[] args) {
        System.out.println("Flux Skip");
        testSkipCount().subscribe(System.out::println);
        System.out.println("Flux Skip Duration");
        testSkipDuration().subscribe(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Flux Skip Last");
        testSkipLast().subscribe(System.out::println);
        System.out.println("Flux Skip Complex");
        testSkipComplex().subscribe(System.out::println);
    }
}
