package com.xxx.aspectj.xml;
/**
 * 
 * <p>Title: CalculateImpl</p>  
 * <p>Description: 目标实现类</p>  
 * @author  王鹏帆  
 * @date  2019年11月26日
 */
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
