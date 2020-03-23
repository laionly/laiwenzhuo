package com.ep.ep.util;


import com.ep.ep.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) ac.getBean("userservice");
		String str="abc";
		String str1=str;
		System.out.println(str=str1);
	}


}
