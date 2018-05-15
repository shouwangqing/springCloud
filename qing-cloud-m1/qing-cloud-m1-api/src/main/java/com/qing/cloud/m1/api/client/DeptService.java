package com.qing.cloud.m1.api.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qing.cloud.m1.api.entity.Dept;

@FeignClient(name="qing-cloud-m1-provider",fallback=DeptServiceHystrix.class)
public interface DeptService {

	String PREFIX="dept";
	
	@RequestMapping(PREFIX+"/add")
	public boolean add(@RequestBody Dept dept);
	
	@RequestMapping(PREFIX+"/find/{id}")
	public Dept findById(@PathVariable("id")Integer id);
	
	@RequestMapping(PREFIX+"/findAll")
	public List<Dept> findAll();
}
