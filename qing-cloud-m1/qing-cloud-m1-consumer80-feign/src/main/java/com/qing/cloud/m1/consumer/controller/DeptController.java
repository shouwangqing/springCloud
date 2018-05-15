package com.qing.cloud.m1.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qing.cloud.m1.api.client.DeptService;
import com.qing.cloud.m1.api.entity.Dept;

@RestController
@RequestMapping("consume/dept")
public class DeptController {
	private final static Logger LOG=LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("add")
	public Boolean add(@RequestBody Dept dept) {
		LOG.info("参数Dept:{}",JSON.toJSONString(dept));
		return deptService.add(dept);
	}
	
	@RequestMapping("/find/{id}")
	public Dept findById(@PathVariable("id")Integer id) {
		return deptService.findById(id);
	}
	
	@RequestMapping("findAll")
	public List<Dept> findAll(){
		return deptService.findAll();
	}
}
