package com.proxy;
/**
 * 
 *<p>Title:TestCalculate</p>
 *<p>Description:测试计算</p>
 * @author 赖文卓
 * @date 2019年11月25日
 */
public class TestCalculate {
	public static void main(String args[]){
		Calculate calculate=new CalculateImpl();
		int result=calculate.add(2, 2);
		System.out.println(result);
		//静态代理测试
		CalculateProxyImpl cpy =new CalculateProxyImpl(calculate);
		System.out.println(cpy.add(2, 2));
		//动态代理测试之JDK
		CalculateDynamicProxyImpl cdy=new CalculateDynamicProxyImpl(calculate);
		Calculate dynamic = cdy.getProxyDynamic();
		System.out.println(dynamic.getClass());
		System.out.println(dynamic.add(2, 2));
	}

}
