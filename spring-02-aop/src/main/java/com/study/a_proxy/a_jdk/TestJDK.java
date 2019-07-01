package com.study.a_proxy.a_jdk;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestJDK {
	
	@Test
	public void demo01(){
		UserService userService = MyBeanFactory.createService();
		System.out.println("获取的userService是一个jdk的动态代理对象："+userService.getClass());
		System.out.println(userService instanceof UserServiceImpl);
		System.out.println(userService instanceof UserService);
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
	/**
	 * 
	 * @描述：所有的类的类加载器只一个，通过不同类获取的类加载器是同一个
	 * @作者：严磊
	 * @时间：Jun 30, 2019 9:34:10 PM
	 */
	@Test
	public void test01() {
	    ClassLoader classLoader1 = MyBeanFactory.class.getClassLoader();
	    ClassLoader classLoader2 = TestJDK.class.getClassLoader();
	    System.out.println(classLoader1);
	    System.out.println(classLoader2);
	}
	
	/**
	 * 
	 * @描述：通过类对象，获取该类的接口里的方法。必须要该类有接口，否则为空
	 * @作者：严磊
	 * @时间：Jun 30, 2019 9:39:47 PM
	 */
	@Test
	public void test02() {
	    UserServiceImpl userService = new UserServiceImpl();
	    Class<?>[] interfaces = userService.getClass().getInterfaces();
	    for (Class<?> class1 : interfaces)
        {
	        Method[] methods = class1.getMethods();
	        for (Method method : methods)
            {
                System.out.println(method.getName());
            }
        }
	}
	
	

}
