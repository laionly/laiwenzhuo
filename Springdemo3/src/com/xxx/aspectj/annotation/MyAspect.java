package com.xxx.aspectj.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/*import org.springframework.core.annotation.Order;*/
import org.springframework.stereotype.Component;

/**
 * 在Java文件中选择类名，然后Copy Qualified Name;
 * <p>
 * Title: MyAspect
 * </p>
 * <p>
 * Description:切面之注解
 * </p>
 * 
 * @author wpf
 * @date 2019年11月26日
 */
@Component //实例化这个类，注入IOC容器
@Aspect //表示这个是个切面类

// 通过@Order(*)标注指定切面优先级，*整数数值越小，优先级越高
//执行顺序与方法名所对应的ASCII值的顺序有关
public class MyAspect {
	// 定义切点
	@Pointcut("execution(* com.xxx.aspectj.annotation.CalculateImpl.*(..))")
	public void pointcut() {

	}

	@Before("pointcut()")//方法名称
	public void beforeone(JoinPoint jp) {
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println(name + "前置通知1执行" + ",参数列表是" + Arrays.asList(args));
	}

	@Before("execution(* com.xxx.aspectj.annotation.CalculateImpl.*(..))")
	public void beforefive(JoinPoint jp) {
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println(name + "前置通知2执行" + ",参数列表是" + Arrays.asList(args));
	}

	@After("execution(public int com.xxx.aspectj.annotation.CalculateImpl.*(..))")
	public void four() {
		System.out.println("最终通知执行");
	}

	@AfterReturning(pointcut = "execution(public int com.xxx.aspectj.annotation.CalculateImpl.*(..))", returning = "re")//returning属性值等于Object形参的对象名
	public void two(JoinPoint jp, Object re) {

		String name = jp.getSignature().getName();
		System.out.println(name + "后置通知执行的返回结果是" + re);
	}

	@AfterThrowing(pointcut = "execution(public int com.xxx.aspectj.annotation.CalculateImpl.*(..))", throwing = "ex")//throwing属性值等于Exception形参的对象名
	public void three(JoinPoint jp, Exception ex) {
		System.out.println("异常通知执行的异常信息为" + ex);
	}

	@Around("execution(public int com.xxx.aspectj.annotation.CalculateImpl.*(..))")
	public Object five(ProceedingJoinPoint pjp){
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		System.out.println(name+"环绕前置就绪，参数列表是："+Arrays.asList(args));
		Object result=null;
		try {
			result = pjp.proceed();
			System.out.println(name+"的环绕返回结果是："+result);
		} catch (Throwable e) {
			
			e.printStackTrace();
			System.out.println("异常通知执行");
		}finally{
			System.out.println(name+"环绕后置执行完毕，参数列表是："+Arrays.asList(args));
		}
		
		
		return result;
	}
}
