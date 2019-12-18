package com.xxx.schema;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * <p>Title: BeforeAdvice</p>  
 * <p>Description: aop通知类型之前置通知(MethodBeforeAdvice)</p>  
 * @author  wpf 
 * @date  2019年11月26日
 */
public class BeforeAdvices implements MethodBeforeAdvice{
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("切面方法对象是"+arg0);
		System.out.println("切面方法参数列表是"+Arrays.asList(arg1));
		System.out.println("切面方法应用的对象是"+arg2);
		System.out.println("前置通知执行");
		
	}

}
