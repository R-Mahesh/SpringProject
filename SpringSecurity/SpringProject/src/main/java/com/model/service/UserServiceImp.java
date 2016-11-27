package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.UserDao;
import com.model.entity.User;
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	@Transactional
	public int addUser(User user) {
return userDao.addUser(user);		
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

	
}
