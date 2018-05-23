package com.qing.cloud.m1.consumer.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.qing.cloud.m1.api.entity.Dept;

@RestController
@RequestMapping("dept")
public class DeptController {
	private final static Logger LOG=LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	private static final String SERVICE_ID="qing-cloud-m1-provider";

	
	
	@RequestMapping("add")
	public Boolean add(Dept dept) {
		LOG.info("参数Dept:{}",JSON.toJSONString(dept));
		
		ServiceInstance instance = loadBalancerClient.choose(SERVICE_ID);
        URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
		
		return restTemplate.postForObject(uri+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping("/find/{id}")
	public Dept findById(@PathVariable("id")Integer id) {
		ServiceInstance instance = loadBalancerClient.choose(SERVICE_ID);
        URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        
		return restTemplate.getForObject(uri+"/dept/find/"+id, Dept.class);
	}
	
	@RequestMapping("findAll")
	public List<Dept> findAll(){
		ServiceInstance instance = loadBalancerClient.choose(SERVICE_ID);
        URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        
        LOG.info("啊啊啊啊啊啊啊啊:"+JSON.toJSONString(uri));
        
		return restTemplate.getForObject(uri+"/dept/findAll", List.class);
	}
}
