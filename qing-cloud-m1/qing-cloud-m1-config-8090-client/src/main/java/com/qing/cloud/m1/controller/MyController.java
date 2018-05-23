package com.qing.cloud.m1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${age}")
	private String age;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("hello")
	public String hello() {
		return age;
	}
	
	@RequestMapping("hi")
	public String hi() {
		return env.getProperty("age");
	}
}
