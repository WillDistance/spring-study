package com.itheima.b_di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestDI {
	
	@Test
	public void demo01(){
		//��spring�������  ����xml�ļ���ʱ���ʵ����
		String xmlPath = "bean-config/b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}
	
	
	@Test
	public void demo02(){
		//ʹ��BeanFactory  --��һ�ε���getBeanʱʵ��������
		String xmlPath = "bean-config/b_di/beans.xml";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		bookService.addBook();
	}

}
