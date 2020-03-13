package com.mybatis.entity;

import java.util.List;

/**
 * 
 * <p>Title: Student</p>  
 * <p>Description: </p>  
 * @author  王鹏帆  
 * @date  2019年4月22日
 */
public class Student {
	private Integer id;
	private String stuNum;
	private String name;
	//多对多的关系映射，一个学生可以具备多个角色
	private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student() {
		
	}
	public Student(String stuNum, String name) {
		super();
		this.stuNum = stuNum;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuNum=" + stuNum + ", name=" + name + "]";
	}
	

}
