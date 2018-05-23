package com.qing.cloud.m1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {

	@Value("${age}")
	private String age;  //需要加@RefreshScope才能刷新内存
	
	@Autowired
	private Environment env; //不需要加@RefreshScope，直接读取本地
	
	@RequestMapping("hello")
	public String hello() {
		return age;
	}
	
	@RequestMapping("hi")
	public String hi() {
		return env.getProperty("age");
	}
}
