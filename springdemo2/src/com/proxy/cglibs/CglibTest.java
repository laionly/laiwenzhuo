package com.proxy.cglibs;

//测试类
public class CglibTest {
	public static void main(String[] args) {
		// 创建代理对象
		CalculateCglibProxy cglibProxy = new CalculateCglibProxy();
     // 创建目标对象
		CalculateImpl ci = new CalculateImpl();
     // 获取增强后的目标对象
		CalculateImpl ci1 = (CalculateImpl)cglibProxy.getCglibProxy(ci);
		// 执行方法
		
		System.out.println(ci1.add(2, 2));
		
	}
}
