package com.model.service;

import java.util.List;

import com.model.entity.User;
import com.model.entity.User_authorization;

public interface UserService {
	public int addUser(User user);
	public void editUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public List getAllUser();
	public int addAuth(User_authorization user_authorization);
	public List getUserByName(String username);
}
