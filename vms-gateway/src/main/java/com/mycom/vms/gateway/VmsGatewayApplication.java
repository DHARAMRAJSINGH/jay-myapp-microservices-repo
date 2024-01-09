package com.mycom.vms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableEurekaClient
@SpringBootApplication
public class VmsGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(VmsGatewayApplication.class, args);
    }

    @LoadBalanced
    @Bean
    WebClient.Builder webClientBuilder () {
        return WebClient.builder();
    }

}
