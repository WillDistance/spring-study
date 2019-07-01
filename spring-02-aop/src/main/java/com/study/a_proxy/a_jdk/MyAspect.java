package com.study.a_proxy.a_jdk;

/**
 * 
 * @描述: 切面类
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 30, 2019 
 * @创建时间: 9:27:54 PM
 */
public class MyAspect {
	
	public void before(){
		System.out.println("鸡首");
	}
	
	public void after(){
		System.out.println("牛后");
	}

}
