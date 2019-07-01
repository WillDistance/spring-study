package com.study.a_proxy.a_jdk;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestJDK {
	
	@Test
	public void demo01(){
		UserService userService = MyBeanFactory.createService();
		System.out.println("��ȡ��userService��һ��jdk�Ķ�̬�������"+userService.getClass());
		System.out.println(userService instanceof UserServiceImpl);
		System.out.println(userService instanceof UserService);
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
	/**
	 * 
	 * @���������е�����������ֻһ����ͨ����ͬ���ȡ�����������ͬһ��
	 * @���ߣ�����
	 * @ʱ�䣺Jun 30, 2019 9:34:10 PM
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
	 * @������ͨ������󣬻�ȡ����Ľӿ���ķ���������Ҫ�����нӿڣ�����Ϊ��
	 * @���ߣ�����
	 * @ʱ�䣺Jun 30, 2019 9:39:47 PM
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
