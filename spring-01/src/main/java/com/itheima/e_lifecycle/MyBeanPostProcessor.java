package com.itheima.e_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
      postProcessBeforeInitialization方法会在每一个bean对象的初始化方法调用之前回调
      postProcessAfterInitialization方法会在每个bean对象的初始化方法调用之后被回调
                两个方法都返回Object类型的实例，返回值既可以是将入参Object bean原封不动的返回出去，也可以对当前bean进行包装再返回
         
                以通过 new CopyOfUserServiceImpl() 新的对象返回 替代传入的bean对象
                接口中两个方法不能返回null，如果返回null那么在后续初始化方法将报空指针异常或者通过getBean()方法获取不到bena实例对象
                因为后置处理器从Spring IoC容器中取出bean实例对象没有再次放回IoC容器中
     */
    
    
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前方法 ： " + beanName);
		
		//return new CopyOfUserServiceImpl(); //改变bean对象
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("后方法 ： " + beanName);
		// bean 目标对象
		// 生成 jdk 代理
		return Proxy.newProxyInstance(
					MyBeanPostProcessor.class.getClassLoader(), 
					bean.getClass().getInterfaces(), 
					new InvocationHandler(){
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							
							System.out.println("------开启事务");
							
							//可以通过method.getName() 获取方法名来判断做一些针对指定方法的操作
							
							//执行目标方法
							Object obj = method.invoke(bean, args);
							
							System.out.println("------提交事务");
							return obj;
						}});
	}
}
