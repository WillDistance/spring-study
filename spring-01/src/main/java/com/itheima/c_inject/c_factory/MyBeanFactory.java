package com.itheima.c_inject.c_factory;

/**
 * ʵ������,���з����Ǿ�̬
 *
 */
public class MyBeanFactory {
	
	/**
	 * ����ʵ��
	 * @return
	 */
	public UserService createService(){
		return new UserServiceImpl();
	}

}
