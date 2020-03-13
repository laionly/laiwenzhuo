package com.ep.ep.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatisutil {
	//初始化 SqlSessionFactory 对象
		public static SqlSessionFactory sqlSessionFactory = null;
		static {
			try {
				//使用 MyBatis提供的 Resources类加载 MyBatis的配置文件
				Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				//构建 SqlSessionFactory工厂
				sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//获取SqlSession对象的静态方法
		public static SqlSession getSession(){
			return sqlSessionFactory.openSession();
		}
}
