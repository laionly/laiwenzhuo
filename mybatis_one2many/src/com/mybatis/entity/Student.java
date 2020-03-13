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
	
	//一对多关系映射:主表尸体应该包含从表实体的集合引用
	private List<Score> scores;
	
	
	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
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
