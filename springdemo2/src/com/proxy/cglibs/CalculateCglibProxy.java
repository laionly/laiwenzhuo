package com.proxy.cglibs;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CalculateCglibProxy {
	//声明被代理对象
	private Object target;
	
	
	public Object getCglibProxy(Object target) {
		 this.target = target;
		// 创建一个动态类对象
		Enhancer enhancer = new Enhancer();
		// 确定需要增强的类，设置其父类
		enhancer.setSuperclass(target.getClass());
		// 添加回调函数
		enhancer.setCallback(
				new MethodInterceptor() {
					
					@Override
					public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
						System.out.println("方法准备");
						Object result = arg3.invokeSuper(arg0, arg2);
						System.out.println("方法执行完毕");
						return result;
					}
				}
				);
		// 返回创建的代理类
		return enhancer.create();
		 
	}


	/**
	 * 执行回调接口的方法
	 * proxy CGlib根据指定父类生成的代理对象
	 * method 拦截的方法
	 * args 拦截方法的参数数组
	 * methodProxy 方法的代理对象，用于执行父类的方法 
	 */
	


	

	
}