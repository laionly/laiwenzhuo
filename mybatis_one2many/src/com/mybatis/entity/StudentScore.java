package com.mybatis.entity;

public class StudentScore extends Score {
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return super.toString()+ "StudentScore [name=" + name + "]";
}

}
