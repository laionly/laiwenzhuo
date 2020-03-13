package com.ep.ep.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;
import com.ep.ep.service.UserService;

public class test {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) ac.getBean("userservice");
		System.out.println(new Date());
		
		

	}

}
