package com.qing.cloud.m1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qing.cloud.m1.rabbitmq.Publisher;

@RestController
public class MyController {

	@Autowired
	private Publisher publisher;
	
	@RequestMapping("hello")
	public String hello() {
		publisher.publish();
		
		return "success";
	}

}
