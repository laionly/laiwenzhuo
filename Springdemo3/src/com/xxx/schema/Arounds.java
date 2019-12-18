package com.xxx.schema;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 
 * <p>Title: Arounds</p>  
 * <p>Description: aop通知类型之环绕通知(MethodInterceptor)</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class Arounds implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("前置通知执行中");
		Object proceed = arg0.proceed();
		System.out.println("环绕通知的结果"+proceed);
		System.out.println("后置通知执行中");
		return proceed;
	}

	

}
