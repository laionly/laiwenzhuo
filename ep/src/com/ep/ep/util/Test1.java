package com.ep.ep.util;

import org.apache.ibatis.session.SqlSession;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Product;
import com.ep.ep.entity.User;



public class Test1 {

	public static void main(String[] args) {
		try{
			SqlSession sqlSession=Mybatisutil.getSession();
			//一对一关联映射
			/*Product product=sqlSession.selectOne("com.ep.ep.dao.product.ProductDao.findProductById", 1);
			System.out.println(product);
			sqlSession.commit();
			sqlSession.close();*/
			
			//一对多关联映射
			User user=sqlSession.selectOne("com.ep.ep.dao.adminuser.AdminUserDao.findUserAllById", 1);
			System.out.println(user);
			sqlSession.commit();
			/*Orderbase orderbase=sqlSession.selectOne("com.ep.ep.dao.orderbase.OrderBaseDao.findOrderbase",1);
			System.out.println(orderbase);
			sqlSession.commit();*/
			/*Orderbase orderbase=sqlSession.selectOne("com.ep.ep.dao.orderbase.OrderBaseDao.findOrderBaseById", 1);
			System.out.println(orderbase);
			sqlSession.commit();*/
			/*
			Order order=sqlSession.selectOne("com.twm.mapper.OrderMapper.findorderandproduct", 1);
			System.out.println(order);
			Product product =sqlSession.selectOne("com.twm.mapper.ProductMapper.findproduct1", 3);
			System.out.println(product);
			sqlSession.commit();
			sqlSession.close();*/
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	}


