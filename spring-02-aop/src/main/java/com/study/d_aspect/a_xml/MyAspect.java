package com.study.d_aspect.a_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * �����࣬���ж��֪ͨ
 */
public class MyAspect {
	
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ �� " + joinPoint.getSignature().getName());
	}
	
	public void myAfterReturning(JoinPoint joinPoint,Object ret){
		System.out.println("����֪ͨ �� " + joinPoint.getSignature().getName() + " , -->" + ret);
	}
	
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����֪ͨ-ǰ");
		
		//�ֶ�ִ��Ŀ�귽��
		Object obj = joinPoint.proceed();
		
		System.out.println("����֪ͨ-��");
		return obj;
	}
	//�쳣֪ͨ �����쳣 �����ǰ��֪ͨ �� ����֪ͨ ��ǰ��֪ͨ�׳��쳣��ֱ����ִֹ�У���������ִ���쳣֪ͨ��ͬ�����쳣֪ͨҲ�޷���׽������֪ͨ���׳����쳣��
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("�׳��쳣֪ͨ �� " + e.getMessage());
	}
	
	public void myAfter(JoinPoint joinPoint){
		System.out.println("����֪ͨ");
	}

}
