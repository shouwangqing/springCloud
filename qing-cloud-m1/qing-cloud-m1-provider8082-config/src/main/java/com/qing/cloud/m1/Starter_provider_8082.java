package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient   //=服务发现，基于spring-cloud-commons
@EnableDiscoveryClient  //服务发现，基于spring-cloud-netflix
public class Starter_provider_8082 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_provider_8082.class, args);
    }
}
