package com.mybatis.ui;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

public class MybatisAnnoTest {
	public static void main(String args[]) throws Exception {
		//1.获取字节输入流
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		//2.根据字节输入流构建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//3.根据SqlSessionFactory产生一个SqlSession
		SqlSession session=factory.openSession();
		//4.使用SqlSession获取Dao的代理对象
		UserDao userDao=session.getMapper(UserDao.class);
		//5.执行Dao的方法
		List<User> users=userDao.findAll();
		for(User user:users) {
			System.out.println(user);
		}
		//6.释放资源
		session.close();
		in.close();

	}
}
