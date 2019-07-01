package com.study.c_spring_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAOP {
	
	@Test
	public void demo01(){
		String xmlPath = "com/study/c_spring_aop/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//获得目标类
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		UserService userService2 = (UserService) applicationContext.getBean("userServiceId2");
		System.out.println(userService.getClass());
		System.out.println(userService2.getClass());
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
