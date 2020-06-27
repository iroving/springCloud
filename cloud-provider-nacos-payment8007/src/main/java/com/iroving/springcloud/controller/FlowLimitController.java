package com.iroving.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    @SentinelResource(value = "testA", blockHandler = "testABlocker", fallback = "testAFallback")
    public String testA() {
        return "------testA";
    }

    public String testABlocker() {
        return "------testA";
    }

    public String testAFallback(Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
        return "------testA";
    }


    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


}
