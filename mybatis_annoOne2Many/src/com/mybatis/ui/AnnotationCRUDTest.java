package com.mybatis.ui;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

public class AnnotationCRUDTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private UserDao userDao;
	
	@Before
	public void init() throws Exception{
		in=Resources.getResourceAsStream("mybatis-config.xml");
		factory=new SqlSessionFactoryBuilder().build(in);
		session=factory.openSession(true);
		userDao=session.getMapper(UserDao.class);
	}
	@After
	public void destroy() throws Exception{
		session.close();
		in.close();
	} 
	@Test
	public void testfindAll() {
		List<User> users=userDao.findAll();
		for (User user:users) {
			System.out.println("-------每个用户的信息-------");
			System.out.println(user);
			System.out.println(user.getAccounts());
		}
	}
	
	@Test
	public void testfindUserById() {
		
		User user=userDao.findUserById(1);
		System.out.println(user);
		
		User user1=userDao.findUserById(1);
		System.out.println(user1);
		
		System.out.println(user=user1);
	}
	@Test
	public void testfindUsersByName() {
		List<User> users=userDao.findUsersByName("赖");
		for (User user:users) {
			System.out.println(user);
		}
	}
	
}
