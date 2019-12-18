package com.xxx.schema;

import org.springframework.aop.ThrowsAdvice;
/**
 * 
 * <p>Title: ThrowAdvice</p>  
 * <p>Description: aop通知类型之异常通知(ThrowsAdvice)</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
public class ThrowAdvice implements ThrowsAdvice{
	
	//注意异常类型
	public void afterThrowing(Exception ex) throws Throwable {
       System.out.println("异常信息是"+ex.getMessage());
       System.out.println("异常通知执行");
    }
	

}
