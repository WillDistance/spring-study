package com.study.b_factory_bean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * @描述: 前置通知
 * @版权: Copyright (c) 2019 
 * @公司: 思迪科技 
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: 2019年7月1日 
 * @创建时间: 下午3:11:39
 */
public class MyAspect2 implements MethodBeforeAdvice
{
    
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("前置通知，方法名："+method.getName());
        System.out.println("参数数组："+args.toString());
        System.out.println("目标对象："+target.getClass());
    }
    
}
