package com.qing.cloud.m1.provider.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qing.cloud.m1.api.entity.Dept;

@Mapper
public interface DeptDao {
	Integer add(Dept dept);
	
	Dept findById(Integer id);
	
	List<Dept> findAll();
}
