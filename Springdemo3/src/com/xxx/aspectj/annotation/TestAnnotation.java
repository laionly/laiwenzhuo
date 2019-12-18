package com.xxx.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * <p>Title: TestAnnotation</p>  
 * <p>Description: 测试类(aspectj之annotation)</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class TestAnnotation {

	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext2.xml");
		CalculateImpl cal=(CalculateImpl) ac.getBean("calculateImpl");
		System.out.println(cal.add(3, 3));

	}

}
