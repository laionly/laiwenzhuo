package com.mybatis.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import com.mybatis.entity.Role;
import com.mybatis.entity.Student;
import com.mybatis.mapper.RoleMapper;
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
public class TestRoleMapper {

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
	 * 查询所有角色
	 */
	@Test
	public void selectAllStudents() {
		SqlSession session = null;
		try {

			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			System.out.println(mapper.getClass());
			List<Role> list = mapper.findAll();
			for (Role Role : list) {
				System.out.println("-------每个角色的信息-------");
				System.out.println(Role);
				System.out.println(Role.getStudents());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
