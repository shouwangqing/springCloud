package com.qing.cloud.m1.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用来查看有哪些服务,测试用
@RestController
@RequestMapping("service")
public class ServiceController {
	private final static Logger LOG=LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("discovery")
	public List<String> discovery() {
		List<String> serviceList=discoveryClient.getServices(); //获取服务名列表，由spring.application.name=qing-cloud-m1-provider定
		
		for(String service:serviceList) {
			List<ServiceInstance>  serviceInstanceList=discoveryClient.getInstances(service);
			for(ServiceInstance serviceInstance:serviceInstanceList) {
				LOG.info("uri:"+serviceInstance.getUri());
				LOG.info("host:"+serviceInstance.getHost());
				LOG.info("port:"+serviceInstance.getPort());
				LOG.info("serviceId:"+serviceInstance.getServiceId());
			}
		}
		
		return serviceList;
	}
}
