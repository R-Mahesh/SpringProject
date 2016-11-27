package com.model.dao;

import javax.sql.DataSource;

import com.model.entity.User;

public interface ValidateUserDao {
	
	public abstract boolean authenticateUser(User user);
}
