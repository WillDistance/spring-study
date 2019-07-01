package com.study.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�ӿڣ��ӿھ��ǹ淶���Ӷ���ȷ���������ơ�
 * * ���á�����֪ͨ�� MethodInterceptor
 *
 */
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("ǰ3");
		
		//�ֶ�ִ��Ŀ�귽��
		Object obj = mi.proceed();
		
		System.out.println("��3");
		return obj;
	}
}
