package com.spring;
/**
 * 
 *<p>Title:Profession</p>
 *<p>Description:职业</p>
 * @author 赖文卓
 * @date 2019年11月20日
 */
public class Profession {
	private String name;
	public Profession(){
		
	}

	public Profession(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Profession [name=" + name + "]";
	}

}
