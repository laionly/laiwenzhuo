package com.xxx.tx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.tx.dao.AccountDao;
import com.xxx.tx.service.AccountService;
/**
 * 
 * <p>Title: TestTransaction</p>  
 * <p>Description: spring事务管理</p>  
 * @author  wpf  
 * @date  2019年11月28日
 */
public class TestTransaction {
	

	public static void main(String[] args) {
		test();
		

	}
	/*
	 * 实现转账功能(使用Spring事务)
	 */
	public static void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans2.xml");
		AccountDao ad=(AccountDao) ac.getBean("dao");
		AccountService as=(AccountService) ac.getBean("service");
		as.transfer("小红", "小明", 600);
		System.out.println("转账成功");
	}

}
