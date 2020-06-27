package com.iroving.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/provider/{id}")
    public String provideString(@PathVariable("id") Long id) {
        return "return from server" + serverPort + ":id:" + id;
    }
}
