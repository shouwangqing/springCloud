package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.qing.cloud.ribbon.MyRibbonBalanceRule;

@SpringBootApplication
@EnableDiscoveryClient //服务发现
@RibbonClient(name="qing-cloud-m1-provider",configuration= MyRibbonBalanceRule.class)
public class Starter_consumer_80_ribbon {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_consumer_80_ribbon.class, args);
    }
}
