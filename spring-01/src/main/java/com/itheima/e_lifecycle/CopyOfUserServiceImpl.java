package com.itheima.e_lifecycle;

public class CopyOfUserServiceImpl  {

	
	public void addUser() {
		System.out.println("e_lifecycle add user c");
	}
	
	public void myInit(){
		System.out.println("初始化 c");
	}
	public void myDestroy(){
		System.out.println("销毁 c");
	}

}
