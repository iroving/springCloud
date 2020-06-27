package com.iroving.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl()
    {
        return "haha ";
    }
}
