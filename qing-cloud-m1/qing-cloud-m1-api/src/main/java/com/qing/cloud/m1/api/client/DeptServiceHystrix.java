package com.qing.cloud.m1.api.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qing.cloud.m1.api.entity.Dept;

@Component
public class DeptServiceHystrix implements DeptService{

	@Override
	public boolean add(Dept dept) {
		return false;
	}

	@Override
	public Dept findById(Integer id) {
		Dept dept=new Dept();
		dept.setId(id);
		dept.setDeptName("不存在");
		return dept;
	}

	@Override
	public List<Dept> findAll() {
		List<Dept> deptList=Lists.newArrayList();
		Dept dept=new Dept();
		dept.setDeptName("不存在。。。");
		deptList.add(dept);
		return deptList;
	}

}
