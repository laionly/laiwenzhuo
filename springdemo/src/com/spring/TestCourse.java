package com.spring;

public class TestCourse {

	public static void main(String[] args) {
		Student student=new Student();
//		第一种方式
//		student.studyJavaCourse();
//		student.studyHtmlCourse();
//		第二种方式
//		student.studyCourseByFactory("java");
//		第三种方法
		student.studyCourseByIOC("javaCourse");

	}

}
