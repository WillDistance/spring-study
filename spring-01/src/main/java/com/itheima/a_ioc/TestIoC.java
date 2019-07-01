package com.itheima.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
	
	@Test
	public void demo01(){
		//֮ǰ����
		UserService userService = new UserServiceImpl();
		userService.addUser();
		
	}
	
	@Test
	public void demo02(){
		//��spring�������
		//1 �������
		String xmlPath = "bean-config/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2������� --����Ҫ�Լ�new�����Ǵ�spring�������
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		
	}

}
