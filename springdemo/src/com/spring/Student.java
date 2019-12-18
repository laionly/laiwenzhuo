package com.spring;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
	private String sno;
	private String name;
	private int age;
	private JavaCourse jc;
	private List<Profession> ps;
	private Map<String, Profession> pf;

	public Student() {

	}

	public Student(String sno, String name, int age, JavaCourse jc, List<Profession> ps, Map<String, Profession> pf) {
		super();
		this.sno = sno;
		this.name = name;
		this.age = age;
		this.jc = jc;
		this.ps = ps;
		this.pf = pf;
	}





	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public JavaCourse getJc() {
		return jc;
	}

	public void setJc(JavaCourse jc) {
		this.jc = jc;
	}

	public List<Profession> getPs() {
		return ps;
	}

	public void setPs(List<Profession> ps) {
		this.ps = ps;
	}
	

	public Map<String, Profession> getPf() {
		return pf;
	}

	public void setPf(Map<String, Profession> pf) {
		this.pf = pf;
	}

//	@Override
//	public String toString() {
//		return "Student [sno=" + sno + ", name=" + name + ", age=" + age + ", jc=" + jc + ", ps=" + ps + ", pf=" + pf
//				+ "]";
//	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", age=" + age + ", jc=" + jc + "]";
	}
	

	// 学习课程(一)
	public void studyJavaCourse() {
		Course course = new JavaCourse();
		course.getCourse();

	}



	public void studyHtmlCourse() {
		Course course = new HtmlCourse();
		course.getCourse();

	}

	// 学习课程(二),通过调用课程工厂对象实现选课功能
	public void studyCourseByFactory(String name){
		CourseFactory cf=new CourseFactory();
		cf.getCourse(name);
//		System.out.println(course);
	}
	//学习课程(三),通过IOC方式实现
	public void studyCourseByIOC(String name){
		 //1.实例化Spring容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * 2.获取对象方式
		 * getBean("bean元素的id值")
		 * getBean(*.class);
		 * getBean("bean元素的id值",*.class);
		 */
		JavaCourse jc=(JavaCourse)ac.getBean(name);
		System.out.println(name);
//		JavaCourse jc=(JavaCourse)ac.getBean(JavaCourse.class);
//		JavaCourse jc=(JavaCourse)ac.getBean(name,JavaCourse.class);
		jc.getCourse();
	}

}
