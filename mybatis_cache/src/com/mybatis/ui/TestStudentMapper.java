package com.mybatis.ui;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.entity.Student;
import com.mybatis.mapper.StudentMapper;
import com.mybatis.util.MybatisUtil;

/**
 * 
 * <p>
 * Title: TestStudent
 * </p>
 * <p>
 * Description:对学生进行增删改查
 * </p>
 * 
 * @author 王鹏帆
 * @date 2019年4月22日
 */
public class TestStudentMapper {
	/**
	 * 测试一级缓存
	 */
    @Test
	public void testFirstLevelCache() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student1 = mapper.selectStudent(1);
			System.out.println(student1);
			//两种方法清空缓存
			session.close();
//			session.clearCache();
			
			//再次获取sqlsession对象
			SqlSession session2 = MybatisUtil.getSqlSession();
			StudentMapper mapper2 = session2.getMapper(StudentMapper.class);
			Student student2 = mapper2.selectStudent(1);
			System.out.println(student2);
			System.out.println(student1=student2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
    /**
     * 测试缓存的同步
     */
    @Test
	public void testClearCache() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//1.根据id查学生
			Student student1 = mapper.selectStudent(1);
			System.out.println(student1);
			//2.更新数据
			student1.setName("小黑");
			mapper.updateStudent(student1);
			Student student2 = mapper.selectStudent(1);
			System.out.println(student2);
			System.out.println(student1=student2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

    
    /**
	 * 测试二级缓存
	 */
    @Test
	public void testSecondLevelCache() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student1 = mapper.selectStudent(1);
			System.out.println(student1);
			//两种方法清空缓存
			session.close();
//			session.clearCache();
			
			//再次获取sqlsession对象
			SqlSession session2 = MybatisUtil.getSqlSession();
			StudentMapper mapper2 = session2.getMapper(StudentMapper.class);
			Student student2 = mapper2.selectStudent(1);
			System.out.println(student2);
			System.out.println(student1=student2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
