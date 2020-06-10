package com.iroving.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment (){
        String result = restTemplate.getForObject(INVOME_URL+"/payment/consul",String.class);
        return result;
    }

    @GetMapping("/consumer/payment/consul")
    public String payment2 (){
        ResponseEntity<String> forEntity = restTemplate.getForEntity(INVOME_URL + "/payment/consul", String.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            String body = forEntity.getBody();
            return "成功" + body;
        } else {
            return "失败";
        }
//        return result;
    }


}
