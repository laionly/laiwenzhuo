package com.xxx.aspectj.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * <p>Title: MyAspect</p>  
 * <p>Description:切面类 </p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class MyAspect {
	//在Java文件中选择类名，然后Copy Qualified Name;
	//怎样访问当前连接点的细节
	public void one(JoinPoint jp){
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println(name+"前置通知执行"+",参数列表是"+Arrays.asList(args));
	}
	public void two(JoinPoint jp,Object re){
		
		String name = jp.getSignature().getName();
		System.out.println("后置通知执行的返回结果是"+re);
	}
	public void three(JoinPoint jp,Exception ex){
		System.out.println("异常通知执行的异常信息为"+ex);
	}
	public void four(){
		System.out.println("最终通知执行");
	}
	public Object five(ProceedingJoinPoint pjp){
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		Object result=null;
		try {
			System.out.println(name+"环绕准备就绪，参数列表是："+Arrays.asList(args));
			System.out.println("前置通知执行");
			result = pjp.proceed();
			System.out.println(name+"的返回结果是："+result);
			System.out.println("后置通知执行");
		} catch (Throwable e) {
			
			e.printStackTrace();
			System.out.println("异常通知执行");
		}finally{
			System.out.println(name+"环绕执行完毕，参数列表是："+Arrays.asList(args));
			System.out.println("最终通知执行");
		}
		
		
		return result;
		
	}
}
