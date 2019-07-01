package com.study.d_c3p0;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.a_domain.User;

public class TestC3P0 {
	
	@SuppressWarnings("resource")
    @Test
	public void demo01(){
		
		String xmlPath = "com/study/d_c3p0/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//获得目标类
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		List<User> allUser = userDao.findAll();
		for (User user : allUser) {
			System.out.println(user);
		}
	}

}
