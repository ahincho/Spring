package com.learning.spring.webflux.essentials.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class WebController {
    @GetMapping
    public Mono<String> handleHome() {
        return Mono.just("home");
    }
}
