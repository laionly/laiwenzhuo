package com.xxx.schema;
import java.lang.reflect.Method;
import org.springframework.aop.*;
/**
 * 
 * <p>Title: AfterReturningsAdvice</p>  
 * <p>Description: aop通知类型之后置通知(AfterReturningAdvice)</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class AfterReturningsAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置通知执行");
		System.out.println("执行结果是"+returnValue);
		
		
	}


}
