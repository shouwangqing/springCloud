package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Starter_config_client8090 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_config_client8090.class, args);
    }
}
