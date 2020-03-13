package com.lwz.spring.util;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lwz.spring.entity.Student;
import com.lwz.spring.service.StudentService;
import com.lwz.spring.service.impl.StudentServiceImpl;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestSpring {

	public static void main(String[] args) {
		//SpringAOP动态代理
//		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//		Student student=(Student) ac.getBean("student");
//		System.out.println(student.toString());
//		StudentService ss=(StudentService)ac.getBean("stdservice");
//		ss.saveStudent(1);

		// 动态代理（基于接口的动态代理）
		StudentServiceImpl stdImpl = new StudentServiceImpl();
		StudentService serviceproxy = (StudentService) Proxy.newProxyInstance(stdImpl.getClass().getClassLoader(),
				stdImpl.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object rtvalue = null;
						int id=(int)args[0];
						if ("saveStudent".equals(method.getName())) {
							if(id>0) {
								
								rtvalue=method.invoke(stdImpl, id);
							}
						}
						if ("deleteStudentById".equals(method.getName())) {
							if (id>0) {
								rtvalue=method.invoke(stdImpl, id);
							}
						}
						return rtvalue;
					}
				});
		serviceproxy.saveStudent(10);
		serviceproxy.deleteStudentById(10);
		
		
		//基于子类动态代理(需要导包：cglib、，asm)
		StudentServiceImpl cglibStudent=(StudentServiceImpl) Enhancer.create(stdImpl.getClass(), new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
				Object rtvalue = null;
				int id=(int)arg[0];
				if ("saveStudent".equals(method.getName())) {
					if(id>0) {
						
						rtvalue=method.invoke(stdImpl, id);
					}
				}
				if ("deleteStudentById".equals(method.getName())) {
					if (id>0) {
						rtvalue=method.invoke(stdImpl, id);
					}
				}
				return rtvalue;
			}
			
		});
		cglibStudent.saveStudent(10);
		cglibStudent.deleteStudentById(10);

	}

}
