package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 *<p>Title:TestDI</p>
 *<p>Description:依赖注入的实现</p>
 * @author 赖文卓
 * @date 2019年11月18日
 */
public class TestDI {

	public static void main(String[] args) {
		//1.实例化Spring容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用setter方法注入
		Student student= (Student) ac.getBean("student");
		System.out.println(student);
		//使用构造方法注入
		Student student1= (Student) ac.getBean("student1");
		System.out.println(student1);

	}

}
