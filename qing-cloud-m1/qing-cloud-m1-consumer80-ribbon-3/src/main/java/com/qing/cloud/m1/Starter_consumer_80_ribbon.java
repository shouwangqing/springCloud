package com.qing.cloud.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.qing.cloud.m1.ribbon.MyExclude;
import com.qing.cloud.m1.ribbon.MyRibbonBalanceRule;

@SpringBootApplication
@EnableDiscoveryClient //服务发现
@RibbonClient(name="qing-cloud-m1-provider",configuration= MyRibbonBalanceRule.class)
@ComponentScan(excludeFilters= {@ComponentScan.Filter(type=FilterType.ANNOTATION,value=MyExclude.class)})
public class Starter_consumer_80_ribbon {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter_consumer_80_ribbon.class, args);
    }
}
