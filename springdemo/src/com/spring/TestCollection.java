package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	public static void main(String args[]) {
		// //1.实例化Spring容器
		// ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext2.xml");
		// Student student= (Student) ac.getBean("student");
		// System.out.println(student);

		// 1.实例化Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext3.xml");
		Student student = (Student) ac.getBean("student");
		System.out.println(student);
	}

}
