package com.qing.cloud.m1.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static final String REST_URL_PREFIX="http://qing-cloud-m1-provider";
	
	@RequestMapping("add")
	public Boolean add(Dept dept) {
		LOG.info("参数Dept:{}",JSON.toJSONString(dept));
		
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping("/find/{id}")
	public Dept findById(@PathVariable("id")Integer id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/find/"+id, Dept.class);
	}
	
	@RequestMapping("findAll")
	public List<Dept> findAll(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll", List.class);
	}
}
