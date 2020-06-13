package com.iroving.springcloud.controller;

import com.iroving.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//这个是全局的兜底方法
@DefaultProperties(defaultFallback = "gloableFallBack")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    //只需要加上这个就会走全局的兜底方法
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        int a = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int a=10/0;
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("ProviderResult:" + result);
        return result;
    }


    //兜底方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        log.info("ProviderResult:特殊兜底");
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id：  " + id + "\t" + "哭了哇呜";
    }

    //兜底方法
    public String gloableFallBack() {
        log.info("ProviderResult:全局兜底");
        return "全局兜底：线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id：  " + "\t" + "哭了哇呜";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    @GetMapping("/payment/hystrix/open/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
//        String serialNumber = IdUtil.simpleUUID();
        String serialNumber = UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }


}

