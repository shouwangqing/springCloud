package com.qing.cloud.m1.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

//自定义负载均衡算法，但不能与启动器同包，或在其子包下
@Configuration
@MyExclude
public class MyRibbonBalanceRule {

	@Bean
	public IRule ribbonRule() {
		System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		return new MyRandomRule();
	}
}
