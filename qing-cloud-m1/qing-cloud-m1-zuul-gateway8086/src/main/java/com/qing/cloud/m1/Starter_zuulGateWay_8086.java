package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //内置了@EnableDiscoveryClient
public class Starter_zuulGateWay_8086 {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_zuulGateWay_8086.class, args);
    }
}
