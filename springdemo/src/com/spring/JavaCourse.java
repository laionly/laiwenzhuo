package com.spring;

public class JavaCourse implements Course{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void getCourse() {
		System.out.println("学习java课程");
		
	}

	@Override
	public String toString() {
		return "JavaCourse [name=" + name + "]";
	}
	

}
