package com.lwz.spring.service.impl;

import org.springframework.stereotype.Service;

import com.lwz.spring.service.StudentService;

@Service("stdservice")
public class StudentServiceImpl implements StudentService{

	@Override
	public void saveStudent(int id) {
		System.out.println("存储了一个ID为："+id+"的学生信息");
		//int a=1/0;
		
	}

	@Override
	public void deleteStudentById(int id) {
		System.out.println("删除一个ID为："+id+"的学生信息");
		
	}

}
