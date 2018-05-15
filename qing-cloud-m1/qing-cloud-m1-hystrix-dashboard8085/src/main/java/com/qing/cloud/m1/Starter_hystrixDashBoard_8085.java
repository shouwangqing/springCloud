package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Starter_hystrixDashBoard_8085 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_hystrixDashBoard_8085.class, args);
    }
}
