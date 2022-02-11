package com.hincs.ga.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${application.name}")
    private String applicationName;

    @GetMapping(value = {"/", "/hello"})
    public String hello() {
        return "Hello, " + applicationName + " !!!";
    }
}
