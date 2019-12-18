package com.spring;
/**
 * 
 *<p>Title:CourseFactory</p>
 *<p>Description:课程工厂类</p>
 * @author 赖文卓
 * @date 2019年11月18日
 */
public class CourseFactory {
	/*
	 * 运用设计模式中的工厂模式
	 */
	public Course getCourse(String name){
		//根据形参name产生具体的课程对象
		if(name.equals("java")){
//			System.out.println("java");
			Course course=new JavaCourse();
			course.getCourse();
			return course;
		}else {
			Course course=new HtmlCourse();
			course.getCourse();
			return course;
		}
		
		
	}

}
