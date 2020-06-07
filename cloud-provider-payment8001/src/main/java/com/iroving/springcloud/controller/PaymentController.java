package com.iroving.springcloud.controller;

import com.iroving.springcloud.entity.CommonResult;
import com.iroving.springcloud.entity.Payment;
import com.iroving.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        int a=5/2;
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(500, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById == null) {
            return new CommonResult(500, "查询失败", paymentById);
        } else {
            return new CommonResult(200, "查询成功", paymentById);
        }
    }
}
