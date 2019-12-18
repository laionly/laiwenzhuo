package com.proxy;

/**
 * 
 * <p>
 * Title:CalculateProxyImpl
 * </p>
 * <p>
 * Description:静态代理实现类
 * </p>
 * 
 * @author 赖文卓
 * @date 2019年11月25日
 */
public class CalculateProxyImpl implements Calculate {
	/*
	 * 静态代理模式 静态代理实现类要与目标实现类实现相同的接口
	 * 
	 */
	private Calculate calculate;

	// 声明一个接口对象，并以参数的形式传入到代理类中
	public CalculateProxyImpl(Calculate calculate) {
		super();
		this.calculate = calculate;
	}

	@Override
	public int add(int a, int b) {
		System.out.println("加法操作之前");
		int c = a + b;
		System.out.println("加法操作之后");
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
