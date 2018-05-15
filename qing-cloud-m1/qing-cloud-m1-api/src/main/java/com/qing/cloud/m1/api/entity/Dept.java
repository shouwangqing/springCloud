package com.qing.cloud.m1.api.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable{

	private Integer id;
	private String deptName;
	private String dbSource;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDbSource() {
		return dbSource;
	}
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
}
