package com.qing.cloud.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

//自定义负载均衡算法，但不能与启动器同包，或在其子包下
@Configuration
public class MyRibbonBalanceRule {

	@Bean
	public IRule ribbonRule() {
		System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		return new MyRandomRule();
	}
}
