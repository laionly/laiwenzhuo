package com.xxx.tx.ui;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.tx.dao.impl.BookDaoImpl;
import com.xxx.tx.service.AccountService;
import com.xxx.tx.service.Cashier;
import com.xxx.tx.service.impl.AccountServiceImpl;


/**
 * 
 * <p>Title: TestBook</p>  
 * <p>Description: 测试买书</p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
public class TestBook {

	public static void main(String[] args) {
//		testFindBookPriceByIsbn();
//		testUpdateBookStock();
//		testupdateAccount();
//		testBookService();
		testPropagation();

	}
	/*
	 * 购买多本书(事务传播行为的使用)
	 */
	public static void testPropagation() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans2.xml");
		Cashier cashier=(Cashier)ac.getBean("cashier");
		cashier.checkout("小明", Arrays.asList("0001","0002"));
		
		
	}

	public static void testBookService() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans2.xml");
		AccountService as=(AccountService)ac.getBean("service");
		as.purchase("小明", "0001");
		
		
		
	}

	public static void testupdateAccount() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		BookDaoImpl bd=(BookDaoImpl) ac.getBean("bookDaoImpl");
		boolean result=bd.updateAccount("小明", 30);
		System.out.println(result);
		
	}

	public static void testUpdateBookStock() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		BookDaoImpl bd=(BookDaoImpl) ac.getBean("bookDaoImpl");
		boolean result=bd.updateBookStock("0001");
		System.out.println(result);
		
	}

	public static void testFindBookPriceByIsbn() {
		//加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		BookDaoImpl bd=(BookDaoImpl) ac.getBean("bookDaoImpl");
		int price= bd.findBookPriceByIsbn("0001");
		System.out.println(price);
		
	}

}
