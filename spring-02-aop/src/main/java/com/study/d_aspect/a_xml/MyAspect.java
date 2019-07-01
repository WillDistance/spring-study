package com.study.d_aspect.a_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，含有多个通知
 */
public class MyAspect {
	
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知 ： " + joinPoint.getSignature().getName());
	}
	
	public void myAfterReturning(JoinPoint joinPoint,Object ret){
		System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->" + ret);
	}
	
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕通知-前");
		
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		
		System.out.println("环绕通知-后");
		return obj;
	}
	//异常通知 接收异常 不针对前置通知 和 最终通知 ，前置通知抛出异常，直接终止执行，并不会再执行异常通知。同样，异常通知也无法捕捉到最终通知中抛出的异常。
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("抛出异常通知 ： " + e.getMessage());
	}
	
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知");
	}

}
