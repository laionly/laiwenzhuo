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

import com.mybatis.dao.AccountDao;
import com.mybatis.dao.UserDao;
import com.mybatis.entity.Account;
import com.mybatis.entity.User;

public class AccountTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private AccountDao accountDao;
	
	@Before
	public void init() throws Exception{
		in=Resources.getResourceAsStream("mybatis-config.xml");
		factory=new SqlSessionFactoryBuilder().build(in);
		session=factory.openSession(true);
		accountDao=session.getMapper(AccountDao.class);
	}
	@After
	public void destroy() throws Exception{
		session.close();
		in.close();
	} 
	@Test
	public void testfindAll() {
		List<Account> accounts=accountDao.findAll();
		for (Account account:accounts) {
			System.out.println("-------每个账户的信息-------");
			System.out.println(account);
			System.out.println(account.getUser());
		}
	}
	
	
	
}
