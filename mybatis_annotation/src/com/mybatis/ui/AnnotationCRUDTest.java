package com.mybatis.ui;

import java.io.InputStream;
import java.util.Date;
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
	public void testSave() {
		Date date=new Date();
		User user=new User();
		user.setUsername("赖2");
		user.setAddress("广西南宁");
		user.setSex("男");
		user.setBirthday(date);
		userDao.saveUser(user);
	}
	@Test
	public void testUpdate() {
		Date date=new Date();
		User user=new User();
		user.setUsername("赖文卓");
		user.setAddress("广西南宁");
		user.setBirthday(date);
		user.setSex("男");
		user.setId(2);
		userDao.updateUser(user);
	}
	
	@Test
	public void testDelete() {
		
		userDao.deleteUser(2);
	}
	@Test
	public void testfindUserById() {
		
		User user=userDao.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void testfindUsersByName() {
		List<User> users=userDao.findUsersByName("赖");
		for (User user:users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findTotalUser() {
		int total=userDao.findTotalUser();
		System.out.println(total);
	}
}
