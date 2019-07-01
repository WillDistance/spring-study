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
		//从spring容器获得  解析xml文件的时候就实例化
		String xmlPath = "bean-config/b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}
	
	
	@Test
	public void demo02(){
		//使用BeanFactory  --第一次调用getBean时实例化对象
		String xmlPath = "bean-config/b_di/beans.xml";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		bookService.addBook();
	}

}
