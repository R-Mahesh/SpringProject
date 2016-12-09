package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.ValidateUserDao;
import com.model.entity.User;

public class ValidateUserServiceImp implements ValidateUserService {

	@Autowired
	private ValidateUserDao validateUserDao;
	
	@Transactional
	public boolean authenticateUser(User user) {
		// TODO Auto-generated method stub
		return  validateUserDao.authenticateUser(user);
	}


	

}
