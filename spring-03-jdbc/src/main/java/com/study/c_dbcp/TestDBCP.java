package com.study.c_dbcp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.a_domain.User;

public class TestDBCP {
	
	@Test
	public void demo01(){
		User user = new User();
		user.setId(1);
		user.setUsername("如花");
		user.setPassword("998");
		
		String xmlPath = "com/study/c_dbcp/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//获得目标类
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		userDao.update(user);
	}

}
