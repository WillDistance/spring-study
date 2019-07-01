package com.study.b_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	
	public static void main(String[] args) {
		
		//1 ��������Դ�����ӳأ� dbcp
		BasicDataSource dataSource = new BasicDataSource();
		// * ����4��
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/study");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		
		//2  ����ģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		
		//3 ͨ��api����
		int resultInt = jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "tom","998");
		System.out.println(resultInt);
		
	}

}
