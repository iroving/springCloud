package com.iroving.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceMain.class, args);
    }
}
