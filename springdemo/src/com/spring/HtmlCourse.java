package com.spring;

public class HtmlCourse implements Course{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void getCourse() {
		System.out.println("学习html课程");
		
	}

}
