package com.iroving.springcloud.service;


import com.iroving.springcloud.service.impl.ConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "${service-url.springboot-provider-service}", fallback = ConsumerServiceImpl.class)
public interface IConsumerService {
    @GetMapping(value = "/provider/{id}")
    String consumeMethod(@PathVariable("id") Long id);
}
