package com.proxy;
/**
 * 
 *<p>Title:CalculateImpl</p>
 *<p>Description:目标实现类</p>
 * @author 赖文卓
 * @date 2019年11月25日
 */
public class CalculateImpl implements Calculate{

	@Override
	public int add(int a, int b) {
		//System.out.println("加法操作之前");
		int c=a+b;
		//System.out.println("加法操作之后");
		return c;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int divide(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
