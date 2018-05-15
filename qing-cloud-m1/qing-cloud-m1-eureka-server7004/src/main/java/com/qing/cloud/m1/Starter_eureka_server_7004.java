package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //开启注册中心
public class Starter_eureka_server_7004 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_eureka_server_7004.class, args);
    }
}
