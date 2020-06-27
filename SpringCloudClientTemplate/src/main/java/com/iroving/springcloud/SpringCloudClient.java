package com.iroving.springcloud;

import com.iroving.Rules.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClients(value = {
        @RibbonClient(name = "${service-url.springboot-provider-service}", configuration = MyRule.class)
})
//@RibbonClients(value = {
//        @RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)),
//@RibbonClient(name = "demo",configuration = DemoRibbonConfig.class)
//})
public class SpringCloudClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClient.class, args);
    }
}
