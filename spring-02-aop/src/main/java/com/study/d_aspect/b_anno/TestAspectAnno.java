package com.study.d_aspect.b_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {
	
	@Test
	public void demo01(){
		String xmlPath = "com/study/d_aspect/b_anno/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//���Ŀ����
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
