package com.intance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intance.constructor.BeanOne;
import com.intance.factory.BeanThree;
import com.intance.staticfactory.BeanTwo;

public class TestInstance {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext4.xml");
		BeanOne one = (BeanOne) ac.getBean("bean1");//构造方法实例化
		System.out.println(one);
		BeanOne one1 = (BeanOne) ac.getBean("bean1");//构造方法实例化
		System.out.println(one1==one);
//		BeanTwo two = (BeanTwo) ac.getBean("bean2");//静态工厂实例化
//		System.out.println(two);
//		BeanThree three=(BeanThree)ac.getBean("bean3");//实例工厂实例化
//		System.out.println(three);

	}

}
