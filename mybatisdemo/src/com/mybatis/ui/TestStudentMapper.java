package com.mybatis.ui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.mybatis.entity.QueryVo;
import com.mybatis.entity.Student;
import com.mybatis.mapper.StudentMapper;
import com.mybatis.util.MybatisUtil;

/**
 * 
 * <p>Title: TestStudent</p>  
 * <p>Description:对学生进行增删改查 </p>  
 * @author  王鹏帆  
 * @date  2019年4月22日
 */
public class TestStudentMapper {
	private static  Logger logger = Logger.getLogger(TestStudentMapper.class);
	public static void main(String[] args) {
		//selectAllStudents();
		//selectStudent();
		//addStudent();
		//deleteStudent();
		updateStudent();
		//selectStudentss();
		//传参类型
		//selectStudentsArray();
		//selectStudentsList();
//		selectStudentsMap();
	}
	/*
	 * 传参类型是Map
	 */
	public static void selectStudentsMap() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			Map<String,Object> map=new HashMap<>();
			//map.put("key", 3);
			map.put("keys", "小莉");
			map.put("value", "name");
			List<Student> array = mapper.selectStudentsMap(map);
			for (Student student : array) {
				System.out.println(student);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	/*
	 * 传参类型是List
	 */
	public static void selectStudentsList() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			List<Object> list=new ArrayList<>();
			//list.add(3);
			list.add("小莉");
			list.add("name");
			List<Student> array = mapper.selectStudentsList(list);
			for (Student student : array) {
				System.out.println(student);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	/*
	 * 传参类型是数组
	 */
	public static void selectStudentsArray() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			Object[] obj=new Object[]{"小莉","name"};
			List<Student> list = mapper.selectStudentsArray(obj);
			for (Student student : list) {
				System.out.println(student);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		
	}

	/*
	 * 根据id查询学生
	 */
	private static void selectStudent() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			Student student = mapper.selectStudent(1);
			System.out.println(student);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}
	/*
	 * 修改学生
	 */
	public static void updateStudent() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行SQL语句，
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//1.
			Student student = mapper.selectStudent(2);
			student.setName("lwz123123");
			student.setStuNum("114");
			
//			Student student = new Student();
//			student.setName("lwz");
//			student.setStuNum("114");
//			student.setId(2);
			
			boolean result = mapper.updateStudent(student);
			if(result){
				System.out.println("修改成功");
			}
//			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}
	/*
	 * 删除学生
	 */
	public static void deleteStudent() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行SQL语句，
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			boolean result = mapper.deleteStudent(14);
			if(result){
				System.out.println("删除成功");
			}
			//session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}
	/*
	 * 添加学生
	 */
	public static void addStudent() {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行SQL语句，selectList()第一个参数的值是映射文件中mapper元素的namespace值+select元素id值
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student=new Student("19", "小篮");
			boolean result = mapper.addStudent(student);
			if(result){
				System.out.println("添加成功");
			}
			//session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		
	}
	/*
	 * 查询所有学生
	 */
	public static void selectAllStudents()  {
		SqlSession session=null;
		try {
			
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			System.out.println(mapper.getClass());
			List<Student> list = mapper.selectAllStudents();
			for (Student student : list) {
				System.out.println(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	/*
	 * 根据name模糊查询学生信息
	 */
	public static void selectStudentss() {
		SqlSession session=null;
		try {
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			String name="小";
			List<Student> list =mapper.selectStudentss(name);
			for(Student student:list) {
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
//	<!-- 根据QueryVo中的id集合实现查询用户列表 -->
	@Test
	public void findStudentInIds(){
		SqlSession session=null;
		try {
			session = MybatisUtil.getSqlSession();
			//执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			QueryVo vo=new QueryVo();
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			vo.setIds(list);
			List<Student> users= mapper.findStudentInIds(vo);
			for (Student student : users) {
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
