package com.example.findmyip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IpController {

    @GetMapping("/findmyip")
    public Mono<String> find() {
        return Mono.just("Hello from Jetty");
    }
}
