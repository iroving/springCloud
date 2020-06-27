package com.iroving.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.iroving.springcloud.entity.Payment;
import com.iroving.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${testInfo.info}")
    private String testInfo;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/nacos/{id}")
    @SentinelResource(value = "byUrl")
    public String getPayment(@PathVariable("id") Integer id) {
        System.out.println(testInfo);
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

    //    @GetMapping(value = "/payment/nacos/{id}")
//    public int create(Payment payment) {
//        return paymentService.create(payment);
//    }
    @GetMapping(value = "/paymentdb/nacos/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        System.out.println(1111);
        return paymentService.getPaymentById(id);
    }

}


