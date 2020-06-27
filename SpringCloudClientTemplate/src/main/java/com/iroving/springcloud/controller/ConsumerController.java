package com.iroving.springcloud.controller;

import com.iroving.springcloud.service.IConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private IConsumerService consumerService;

    @GetMapping("/consumer/consumerMethod/{id}")
    public String consumerMethod(@PathVariable("id") Long id) {
        return consumerService.consumeMethod(id);
    }
}
