package com.mybatis.ui;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

public class SecondLevelCatchTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private UserDao userDao;
	
	@Before
	public void init() throws Exception{
		in=Resources.getResourceAsStream("mybatis-config.xml");
		factory=new SqlSessionFactoryBuilder().build(in);
		
	}
	@After
	public void destroy() throws Exception{
		//session.close();
		in.close();
	} 
	
	@Test
	public void testfindUserById() {
		SqlSession session=factory.openSession(true);
		UserDao userDao=session.getMapper(UserDao.class);
		User user=userDao.findUserById(1);
		System.out.println(user);
		session.close();//释放一级缓存
		SqlSession session1=factory.openSession();//再次打开session
		UserDao userDao1=session1.getMapper(UserDao.class);
		User user1=userDao1.findUserById(1);
		System.out.println(user1);
		session1.close();
	}
}
