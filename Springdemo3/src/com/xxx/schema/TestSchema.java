package com.xxx.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * <p>Title: TestSchema</p>  
 * <p>Description: 测试类</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class TestSchema {

	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CalculateImpl cal=(CalculateImpl) ac.getBean("calculateImpl");
		System.out.println(cal.add(2, 2));
		
	}

}
