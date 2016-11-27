package com.model.dao;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.User;

public class ValidateUserDaoImp implements ValidateUserDao {
	
	
	
	
	@Transactional
	public boolean authenticateUser(User user) {
		return false;
	}

	
}
