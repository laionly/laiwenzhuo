package com.intance.staticfactory;

public class StaticFactoryBean {
	public static BeanTwo createBeanTwo(){
		System.out.println("静态工厂实例化");
		return new BeanTwo();
	}

}
