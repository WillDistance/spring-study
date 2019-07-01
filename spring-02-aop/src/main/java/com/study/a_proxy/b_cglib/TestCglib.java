package com.study.a_proxy.b_cglib;

import org.junit.Test;

public class TestCglib {
	
	@Test
	public void demo01(){
		UserServiceImpl userService = MyBeanFactory.createService();
		System.out.println("��ȡ��userService��һ��ͨ��cjlib���ɵĶ�̬�������"+userService.getClass());
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
	
	@Test
	public void demo02(){
	    UserServiceImpl userService = new UserServiceImpl();
	    ProxyFactory pf = new ProxyFactory();
	    Object proxy = pf.createProxy(userService);
	    System.out.println("��ȡ��proxy��һ��ͨ��cjlib���ɵ�userService��̬�������"+proxy.getClass());
	    System.out.println("proxy��UserServiceImpl��һ�����ࣺ"+(proxy instanceof UserServiceImpl));
	    
	    //��Ϊcjlib��ʵ�ֻ��Ƶ�ԭ�򡣻�ȡ��proxy����ʵ������UserServiceImpl������ࡣ���Բſ�������ת��
	    UserServiceImpl proxService = (UserServiceImpl)proxy;
	    System.out.println("��ȡ��proxService��һ��ͨ��cjlib���ɵĶ�̬�������"+proxService.getClass());
	    
	    proxService.addUser();
	    System.out.println("-----------------------------------");
	    proxService.updateUser();
	    System.out.println("-----------------------------------");
	    proxService.deleteUser();
	}
}
