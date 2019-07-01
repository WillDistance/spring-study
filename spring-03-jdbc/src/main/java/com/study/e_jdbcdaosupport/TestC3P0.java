package com.study.e_jdbcdaosupport;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.a_domain.User;

public class TestC3P0 {
	
	@SuppressWarnings("resource")
    @Test
	public void demo01(){
		
		String xmlPath = "com/study/e_jdbcdaosupport/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//���Ŀ����
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		List<User> allUser = userDao.findAll();
		for (User user : allUser) {
			System.out.println(user);
		}
	}

}