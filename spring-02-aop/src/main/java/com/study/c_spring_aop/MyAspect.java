package com.study.c_spring_aop;

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
        
        System.out.println("ǰ4");
        
        //�ֶ�ִ��Ŀ�귽��
        Object obj = mi.proceed();
        
        System.out.println("��4");
        return obj;
    }
}
