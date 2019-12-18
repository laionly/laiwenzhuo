package com.xxx.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.aspectj.xml.CalculateImpl;

public class TestXML {

	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext1.xml");
		CalculateImpl cal=(CalculateImpl) ac.getBean("calculateImpl");
		System.out.println(cal.add(2, 2));

	}

}
