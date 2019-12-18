package com.xxx.sh.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.sh.service.BookService;


public class TestSh {

	public static void main(String[] args) {
		test();

	}

	public static void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		BookService bs=(BookService) ac.getBean("bservice");
		bs.purchase("小明", "0002");
		System.out.println("买书成功");
	}

}
