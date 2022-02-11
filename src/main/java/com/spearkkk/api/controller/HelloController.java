package com.spearkkk.api.controller;

import com.spearkkk.api.configuration.auth.LoginUser;
import com.spearkkk.api.configuration.auth.dto.SessionUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${application.name}")
    private String applicationName;

    @GetMapping(value = {"/", "/hello"})
    public String hello(@LoginUser SessionUser sessionUser) {
        if (sessionUser != null) {
            return "Hello, " + sessionUser + " !!!";
        }

        return "Hello, " + applicationName + " !!!";
    }
}
