package com.mybatis.mapper;

import java.util.List;
import java.util.Map;
import com.mybatis.entity.Student;

/**
 * 
 * <p>
 * Title: StudentMapper
 * </p>
 * <p>
 * Description: Mapper接口
 * </p>
 * 
 * @author 王鹏帆
 * @date 2019年4月24日
 */
public interface StudentMapper {
	/*
	 * 注意： 1.Mapper接口名称必须与映射文件的名称一致，并且在同一目录；
	 * 2.Mapper接口声明的方法名必须与映射文件中select|delete|update|insert元素的id值一致；
	 * 3.映射文件中namespace的值必须是Mapper接口的完全限定名；(包名.类名)
	 */
	public List<Student> selectAllStudents();

	public Student selectStudent(int id);

}
