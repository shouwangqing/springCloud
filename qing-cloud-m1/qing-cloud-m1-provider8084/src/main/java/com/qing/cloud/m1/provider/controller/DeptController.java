package com.qing.cloud.m1.provider.controller;

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
import com.qing.cloud.m1.provider.dao.DeptDao;

@RestController
//@RequestMapping("dept")
public class DeptController implements DeptService{
	private final static Logger LOG=LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptDao deptDao;
	
//	@RequestMapping("/add")
	public boolean add(Dept dept) { //要加上@RequestBody,否则用json访问时，无法传参
		LOG.info("参数Dept:{}",JSON.toJSONString(dept));
		try {
			deptDao.add(dept);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		}
		return false;
	}
	
//	@RequestMapping("/find/{id}")
	public Dept findById(Integer id) {
		return deptDao.findById(id);
	}
	
//	@RequestMapping("findAll")
	public List<Dept> findAll(){
		return deptDao.findAll();
	}
}
