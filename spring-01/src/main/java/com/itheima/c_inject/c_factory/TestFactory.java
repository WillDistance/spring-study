package com.itheima.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	
	@Test
	public void demo01(){
		//�Զ���ʵ������
		//1 ��������
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		//2 ͨ������ʵ������ö���
		UserService userService = myBeanFactory.createService();
		
		userService.addUser();
	}
	@Test
	public void demo02(){
		//spring ����
		String xmlPath = "com/itheima/c_inject/c_factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId" ,UserService.class);
		userService.addUser();
	}

}
