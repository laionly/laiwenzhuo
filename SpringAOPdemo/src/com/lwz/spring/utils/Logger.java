package com.lwz.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("Logger")
@Aspect
public class Logger {
	
	@Pointcut("execution(public void com.lwz.spring.service.impl.StudentServiceImpl.saveStudent())")
	private void cut() {
		
	}
	
	//@Before("cut()")
	public void before() {
		System.out.println("插入前置通知");
	}
	//@AfterReturning("cut()")
	public void afterReturning() {
		System.out.println("插入后置通知");
	}
	//@AfterThrowing("cut()")
	public void afterThrowing() {
		System.out.println("插入异常通知");
	}
	//@After("cut()")
	public void after() {
		System.out.println("插入最终通知");
	}
	@Around("cut()")//一般使用环绕通知
	public Object around(ProceedingJoinPoint pjp) {
		Object rtvalue=null;
		try {
			System.out.println("插入前置通知");//相当于前置通知
			rtvalue=pjp.proceed();
			System.out.println("插入后置通知");//相当于后置通知
		} catch (Throwable e) {
			System.out.println("插入异常通知");//相当于异常通知
			e.printStackTrace();
		}finally {
			System.out.println("插入最终通知");//相当于最终通知
		}
		return rtvalue;
	}

}
