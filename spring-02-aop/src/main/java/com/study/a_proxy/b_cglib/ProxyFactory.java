package com.study.a_proxy.b_cglib;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 
 * @描述: 所有方法的代理的回调
 * @版权: Copyright (c) 2019 
 * @公司: 思迪科技 
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: 2019年7月1日 
 * @创建时间: 下午2:44:28
 */
public class ProxyFactory implements MethodInterceptor {

	//要代理的真实对象
	private Object obj;
	
	public Object createProxy(Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		//设置代理目标
		enhancer.setSuperclass(this.obj.getClass());
		//设置单一回调对象，在调用中拦截对目标方法的调用
		enhancer.setCallback(this);
		//设置类加载器
		enhancer.setClassLoader(this.obj.getClass().getClassLoader());
		
		return enhancer.create();
	}
	/**
	 * 
	 * 方法描述 当对基于代理的方法回调时，在调用原方法之前会调用该方法
	 * 拦截对目标方法的调用
	 *
	 * @param obj 代理对象
	 * @param method 拦截的方法
	 * @param args 拦截的方法的参数
	 * @param proxy 代理
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object result = null;
		try {
			//前置通知
			before();
			result = proxy.invokeSuper(obj, args);
			//后置通知
			after();
		} catch (Exception e) {
			//异常通知
			exception();
		} finally {
			//方法返回前通知
			beforeReturning();
		}
		
		return result;
	}

	private void before() {
		System.out.println("前置  method invoke...");
	}
	private void after() {
		System.out.println("后置  method invoke...");
	}
	private void exception() {
		System.out.println("异常  method invoke...");
	}
	private void beforeReturning() {
		System.out.println("方法返回前  method invoke...");
	}
}