package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/**
 * 
 *<p>Title:CalculateDynamicProxyImpl</p>
 *<p>Description:动态代理实现类</p>
 * @author 赖文卓
 * @date 2019年11月25日
 */
public class CalculateDynamicProxyImpl {
	//声明被代理对象
	private Calculate cal;

	public CalculateDynamicProxyImpl(Calculate cal) {
		super();
		this.cal = cal;
	}
	//被代理对象与代理对象产生关联
	public Calculate getProxyDynamic(){
		//类加载器
		ClassLoader loader=Calculate.class.getClassLoader();
		//被代理对象实现的接口
		//Class<?>[] interfaces={Calculate.class};
		Class<?>[] interfaces=CalculateImpl.class.getInterfaces();
		//invoke方法，调用处理程序必须实现InvocationHandler接口
		InvocationHandler h=new InvocationHandler(){
			/*
			 * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
			 * method:我们所要调用某个对象真实的方法的Method对象
			 * args:指代代理对象方法传递的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("方法准备");
				Object result = method.invoke(cal, args);
				System.out.println(result);
				System.out.println("方法执行完毕");
				return result;
			}
			
		};
		/*
		 * Proxy.newProxyInstance()方法作用是创建一个代理类对象
		 * loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
         * interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
         * h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。

		 */
		Calculate cal =(Calculate) Proxy.newProxyInstance(loader, interfaces, h);
		return cal;
		
	}

}
