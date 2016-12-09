package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.UserDao;
import com.model.entity.User;
import com.model.entity.User_authorization;
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	@Transactional
	public int addUser(User user) {
return userDao.addUser(user);		
	}
	
	@Transactional
	public int addAuth(User_authorization user_authorization) {
return userDao.addAuth(user_authorization);		
	}
	
	
	@Transactional
	public void editUser(User user) {
		userDao.editUser(user);	
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public List getAllUser() {
		return userDao.getAllUser();
	}
	

	@Transactional
	public List getUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(username);
	}
	
}
