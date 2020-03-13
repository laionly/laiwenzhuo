package com.ep.ep.util;

import org.apache.ibatis.session.SqlSession;

import com.ep.ep.entity.Product;



public class Test1 {

	public static void main(String[] args) {
		try{
			SqlSession sqlSession=Mybatisutil.getSession();
			//一对一关联映射
			Product product=sqlSession.selectOne("com.ep.ep.dao.product.ProductDao.findProductById", 1);
			System.out.println(product);
			sqlSession.commit();
			sqlSession.close();
			
			//一对多关联映射
			/*User user=sqlSession.selectOne("com.twm.mapper.UserMapper.finduser", 1);
			System.out.println(user);
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


