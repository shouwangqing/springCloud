package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient //服务发现
@EnableFeignClients
@EnableHystrix         //断路器
//@EnableCircuitBreaker
public class Starter_consumer_80_feign {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_consumer_80_feign.class, args);
    }
}
