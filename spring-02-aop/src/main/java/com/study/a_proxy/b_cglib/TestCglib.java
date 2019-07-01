package com.study.a_proxy.b_cglib;

import org.junit.Test;

public class TestCglib {
	
	@Test
	public void demo01(){
		UserServiceImpl userService = MyBeanFactory.createService();
		System.out.println("获取的userService是一个通过cjlib生成的动态代理对象："+userService.getClass());
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
	
	@Test
	public void demo02(){
	    UserServiceImpl userService = new UserServiceImpl();
	    ProxyFactory pf = new ProxyFactory();
	    Object proxy = pf.createProxy(userService);
	    System.out.println("获取的proxy是一个通过cjlib生成的userService动态代理对象："+proxy.getClass());
	    System.out.println("proxy是UserServiceImpl的一个子类："+(proxy instanceof UserServiceImpl));
	    
	    //因为cjlib的实现机制的原因。获取的proxy对象实际上是UserServiceImpl类的子类。所以才可以向上转型
	    UserServiceImpl proxService = (UserServiceImpl)proxy;
	    System.out.println("获取的proxService是一个通过cjlib生成的动态代理对象："+proxService.getClass());
	    
	    proxService.addUser();
	    System.out.println("-----------------------------------");
	    proxService.updateUser();
	    System.out.println("-----------------------------------");
	    proxService.deleteUser();
	}
}
