package com.study.b_factory_bean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * @����: ǰ��֪ͨ
 * @��Ȩ: Copyright (c) 2019 
 * @��˾: ˼�ϿƼ� 
 * @����: ����
 * @�汾: 1.0 
 * @��������: 2019��7��1�� 
 * @����ʱ��: ����3:11:39
 */
public class MyAspect2 implements MethodBeforeAdvice
{
    
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("ǰ��֪ͨ����������"+method.getName());
        System.out.println("�������飺"+args.toString());
        System.out.println("Ŀ�����"+target.getClass());
    }
    
}
