package com.study.b_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	
	public static void main(String[] args) {
		
		//1 创建数据源（连接池） dbcp
		BasicDataSource dataSource = new BasicDataSource();
		// * 基本4项
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/study");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		
		//2  创建模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		
		//3 通过api操作
		int resultInt = jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "tom","998");
		System.out.println(resultInt);
		
	}

}
