package com.itheima.e_lifecycle;

import org.junit.Test;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
	
	@Test
	public void demo02() throws Exception{
		//spring ����
		String xmlPath = "com/itheima/e_lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		System.out.println(Proxy.isProxyClass(UserServiceImpl.class));
		userService.addUser();
		
		//Ҫ��1.��������close�����ٷ���ִ��; 2.�����ǵ�����
//		applicationContext.getClass().getMethod("close").invoke(applicationContext);
		// * �˷����ӿ���û�ж��壬ʵ�����ṩ
		applicationContext.close();
		
	}

}
