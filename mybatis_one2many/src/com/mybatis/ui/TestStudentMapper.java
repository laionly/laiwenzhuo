package com.mybatis.ui;

import java.util.List;

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

	/*
	 * 根据id查询学生
	 */
	@Test
	public void selectStudent() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			Student student = mapper.selectStudent(1);
			System.out.println(student);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/*
	 * 查询所有学生
	 */
	@Test
	public void selectAllStudents() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			List<Student> list = mapper.selectAllStudents();
			for (Student student : list) {
				System.out.println("-------每个用户的信息-------");
				System.out.println(student);
				System.out.println(student.getScores());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
