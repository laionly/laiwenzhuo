package com.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * <p>Title: MybatisUtil</p>  
 * <p>Description: mybatis封装类</p>  
 * @author  王鹏帆  
 * @date  2019年4月22日
 */
public class MybatisUtil {
	private static SqlSessionFactory sessionFactory;
    static {
        try {
        	//1.加载或读取mybatis配置文件 Configuration类
            InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
           //2.使用SqlSessionFactoryBuilder创建SQLSessionFactory实例
            sessionFactory = new SqlSessionFactoryBuilder().build(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public static SqlSession getSqlSession() {
    	//3.产生SqlSession对象
    	//当openSession为true时(自动提交)，不用写提交操作(session.commit())
        return sessionFactory.openSession(true);
    }


}
