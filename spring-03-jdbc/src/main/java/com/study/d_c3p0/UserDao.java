package com.study.d_c3p0;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.study.a_domain.User;

public class UserDao {
	
	//jdbcģ�彫��springע��
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void update(User user){
		String sql = "update t_user set username=?,password=? where id =?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		jdbcTemplate.update(sql, args);
	}

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<User> findAll() {
		return jdbcTemplate.query("select * from t_user", ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}

}
