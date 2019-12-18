package com.xxx.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xxx.dao.impl.StudentDaoImpl;
import com.xxx.entity.Student;

/**
 * 
 * <p>
 * Title: TestJdbc
 * </p>
 * <p>
 * Description: 测试JdbcTemplate的使用
 * </p>
 * 
 * @author wpf
 * @date 2019年11月28日
 */
public class TestJdbc {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("你要执行的操作:");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			createTable();//创建表
			break;
		case 2:
			addStudent();//添加学生信息
			break;
		case 3:
			updateStudent();//修改学生信息
			break;
		case 4:
			deleteStudent();//删除学生信息
			break;
		case 5:
			batchAddStudents();//批量添加学生信息
			break;
		case 6:
			batchUpdateStudents();//批量修改学生信息
			break;
		case 7:
			batchDeleteStudents();//批量删除学生信息
			break;

		}
		// 简单的增删改查--->批量增删改(两种方式)
		// createTable();
		// addStudent();
		// updateStudent();
		// deleteStudent();
		// batchAddStudents();
		// batchUpdateStudents()<无>;
		// batchDeleteStudents();
		// selectStudentById();
		// selectAllStudents()<无>;
		// addStudentByNamed();
		// batchAddStudentsByNamed();

	}

	/*
	 * 创建数据库表
	 */
	public static void createTable() {
		// 加载配置文件、实例化IOC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DataSource ds = (DataSource) ac.getBean("dataSource");
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		jt.execute("create table student(" + "id int(11) NOT NULL AUTO_INCREMENT," + "stuNo varchar(50) DEFAULT NULL,"
				+ "name varchar(50) DEFAULT NULL," + "sex varchar(50) DEFAULT NULL," + "PRIMARY KEY (`id`))");
		System.out.println("创建表成功");

	}

	/*
	 * 添加学生测试
	 */
	public static void addStudent() {
		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = new Student();
		student.setStuNo("0001");
		student.setName("小莉");
		student.setSex("女");
		int result = sd.addStudent(student);
		if (result > 0) {
			System.out.println("添加学生成功" + result);
		} else {
			System.out.println("添加学生失败" + result);
		}
	}

	/*
	 * 修改学生测试
	 */
	public static void updateStudent() {
		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");// 实现类的类名首字母小写
		Student student = new Student();
		student.setId(4);
		student.setStuNo("0001");
		student.setName("小莉");
		student.setSex("女");
		int result = sd.updateStudent(student);
		if (result > 0) {
			System.out.println("修改学生成功" + result);
		} else {
			System.out.println("修改学生失败" + result);
		}

	}

	/*
	 * 删除学生测试
	 */
	public static void deleteStudent() {
		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		int result = sd.deleteStudent(18);
		if (result > 0) {
			System.out.println("删除学生成功" + result);
		} else {
			System.out.println("删除学生失败" + result);
		}

	}

	/*
	 * 批量添加学生测试
	 */
	public static void batchAddStudents() {
		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = new Student();
		student.setStuNo("0003");
		student.setName("小海");
		student.setSex("男");
		Student student1 = new Student();
		student1.setStuNo("0004");
		student1.setName("小红");
		student1.setSex("女");
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student);
		int result = sd.batchAddStudents(list);
		if (result > 0) {
			System.out.println("添加学生成功" + result);
		} else {
			System.out.println("添加学生失败" + result);
		}

	}

	/*
	 * 批量修改学生信息
	 */
	public static void batchUpdateStudents() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");// 实现类的类名首字母小写
		Student student = new Student();
		student.setId(4);
		student.setStuNo("0001");
		student.setName("小蓝");
		student.setSex("女");
		Student student2 = new Student();
		student2.setId(5);
		student2.setStuNo("0002");
		student2.setName("小紫");
		student2.setSex("女");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		list.add(student2);
		int result = sd.batchUpdateStudents(list);
		if (result > 0) {
			System.out.println("添加学生成功" + result);
		} else {
			System.out.println("添加学生失败" + result);
		}

	}

	/*
	 * 批量删除学生测试
	 */
	public static void batchDeleteStudents() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = new Student();
		student.setId(7);
		Student student1 = new Student();
		student1.setId(8);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(student.getId());
		ids.add(student1.getId());
		int result = sd.batchDeleteStudents(ids);
		if (result > 0) {
			System.out.println("删除学生成功" + result);
		} else {
			System.out.println("删除学生失败" + result);
		}

	}

	/*
	 * 根据id查询学生测试
	 */
	public static void selectStudentById() {
		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = sd.findStudentById(4);
		;
		System.out.println(student);

	}

	/*
	 * 查询全部学生
	 */
	public static void selectAllStudents() {
		// TODO Auto-generated method stub

	}

	/*
	 * 使用具名参数添加学生
	 */
	public static void addStudentByNamed() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = new Student("0004", "小鹿", "女");
		int result = sd.addStudent(student);
		System.out.println(result);

	}

	/*
	 * 使用具名参数批量添加学生测试 SqlParameterSourceUtils类
	 */
	public static void batchAddStudentsByNamed() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl sd = (StudentDaoImpl) ac.getBean("studentDaoImpl");
		Student student = new Student("0005", "小梅", "女");
		Student student1 = new Student("0006", "小蕾", "女");
		Student student2 = new Student("0007", "小雨", "女");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		list.add(student1);
		list.add(student2);
		int result = sd.batchAddStudentsByNamed(list);
		System.out.println(result);

	}

}
