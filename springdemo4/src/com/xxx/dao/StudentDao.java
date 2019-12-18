package com.xxx.dao;

import java.util.List;

import com.xxx.entity.Student;

/**
 * 
 * <p>Title: StudentDao</p>  
 * <p>Description: 接口统一规范，不能实例化方法</p>  
 * @author  wpf  
 * @date  2019年11月28日
 */
public interface StudentDao {
	//添加方法
	public int addStudent(Student student);
	//批量添加方法
	public int batchAddStudents(List<Student> stu);
	//批量添加方法(具名参数)
	public int batchAddStudentsByNamed(List<Student> stu);
	//修改方法
	public int updateStudent(Student student);
	//批量修改方法
	public int batchUpdateStudents(List<Student> stu);
	//删除方法
	public int deleteStudent(Integer id);
	//批量删除方法
	public int batchDeleteStudents(List<Integer> ids);
	//根据id查询学生
	public Student findStudentById(int id);
	//查询全部学生
	public List<Student> findAllStudents();
	/*
	 * 使用具名参数(:属性名)NamedParameterJdbcTemplate
	 * 对象名.update(sql,SqlParameterSource source)
	 * SqlParameterSource：用于进行参数处理
	 */
//	public int deleteStudent(Student student);

	 
	
}
