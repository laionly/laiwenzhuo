package com.xxx.aspectj.annotation;

import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title: CalculateImpl</p>  
 * <p>Description: 目标类</p>  
 * @author  wpf  
 * @date  2019年11月26日
 */
@Component
public class CalculateImpl {
	
	public int add(int a, int b) {
		
		int c=a+b;
		//int d=5/0;
		return c;
	}

	
	public int subtract(int a, int b) {
		
		int c=a-b;

		return c;
	}

	
	public int multiply(int a, int b) {
		int c=a*b;
		return c;
	}

	
	public int divide(int a, int b) {
		int c=a/b;
		return c;
	}


}
