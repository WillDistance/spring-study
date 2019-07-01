package com.study.f_properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.a_domain.User;

public class TestProps {
	
	@Test
	public void demo01(){
		
		String xmlPath = "com/study/f_properties/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//���Ŀ����
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		User user = userDao.getById(1);
		System.out.println(user);
	}

}
