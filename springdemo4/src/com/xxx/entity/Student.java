package com.xxx.entity;


/**
 * 
 * <p>Title: Student</p>  
 * <p>Description:学生实体类，公有方法、私有属性、无参构造 </p>  
 * @author  wpf  
 * @date  2019年11月28日
 */
public class Student {
	private Integer id;
	private String stuNo;
	private String name;
	private String sex;
	public Student(){
		
	}
	
	public Student(Integer id, String stuNo, String name, String sex) {
		super();
		this.id = id;
		this.stuNo = stuNo;
		this.name = name;
		this.sex = sex;
	}

	public Student(String stuNo, String name, String sex) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.sex = sex;
	}
	




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuNo=" + stuNo + ", name=" + name + ", sex=" + sex + "]";
	}


	
	
	

}
