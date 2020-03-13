package com.mybatis.entity;
import java.io.Serializable;

/**
 * 
 * <p>Title: Student</p>  
 * <p>Description: </p>  
 * @author  王鹏帆  
 * @date  2019年4月22日
 */
public class Student implements Serializable{
	private Integer id;
	private String stuNum;
	private String name;
	
	

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
	
	

}
