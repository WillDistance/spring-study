package com.study.a_proxy.a_jdk;

/**
 * 
 * @����: Ŀ����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 30, 2019 
 * @����ʱ��: 9:27:37 PM
 */
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("a_proxy.a_jdk addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("a_proxy.a_jdk updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("a_proxy.a_jdk deleteUser");
	}
	

}
