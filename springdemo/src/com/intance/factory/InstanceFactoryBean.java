package com.intance.factory;

public class InstanceFactoryBean {
	public BeanThree createBean(){
		System.out.println("实例工厂实例化");
		return new BeanThree();
	}
}
