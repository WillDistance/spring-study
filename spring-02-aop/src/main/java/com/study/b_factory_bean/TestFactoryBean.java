package com.study.b_factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	
	@Test
	public void demo01(){
		String xmlPath = "com/study/b_factory_bean/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//��ô�����
		UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
		System.out.println("ʵ�ַ�ʽ�ǣ�"+userService.getClass());
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
