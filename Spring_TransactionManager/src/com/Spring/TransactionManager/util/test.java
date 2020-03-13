package com.Spring.TransactionManager.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.TransactionManager.Service.AccountService;

public class test {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		AccountService as=(AccountService) ac.getBean("AccountService");
		as.transfer(1, 2, 100.0);

	}

}
