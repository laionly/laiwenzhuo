package com.lwz.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//配置使用注解实现自动注入
@Component("student")
public class Student {
	@Value("14")
	private int id;
	@Value("lwz")
	private String name;
	@Value("21")
	private String age;
	@Value("南宁")
	private String address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, String age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"age\":\"" + age + "\", \"address\":\"" + address
				+ "\"}";
	}
	

}
