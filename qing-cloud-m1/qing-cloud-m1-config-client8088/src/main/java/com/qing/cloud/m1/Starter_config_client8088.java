package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Starter_config_client8088 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_config_client8088.class, args);
    }
}
