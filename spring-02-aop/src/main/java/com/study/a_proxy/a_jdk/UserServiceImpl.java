package com.study.a_proxy.a_jdk;

/**
 * 
 * @描述: 目标类
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 30, 2019 
 * @创建时间: 9:27:37 PM
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
