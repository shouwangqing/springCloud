package com.qing.cloud.m1.consumer.configs;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
//	@LoadBalanced  //ribbon的客户端负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//切换负载均衡算法，默认轮询算法
//	@Bean
//	public IRule myRule() {
//		return new RetryRule();
//	}
}
