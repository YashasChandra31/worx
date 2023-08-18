package com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.ILoginDao;



@Repository
public class LoginDaoImpl implements ILoginDao {
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public boolean validateUser(String username, String password) {
		int count = jdbcTemplate.queryForObject("select count(*) from userslogin where username=? and password=?", Integer.class, username, password);
		if (count == 1)
			return true;
		else
		return false;
	}

}

