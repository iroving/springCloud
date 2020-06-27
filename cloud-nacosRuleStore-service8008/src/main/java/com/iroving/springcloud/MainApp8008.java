package com.iroving.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8008 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8008.class, args);
    }
}
