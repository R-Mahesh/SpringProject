package com.model.service;

import java.util.List;

import com.model.entity.Category;
import com.model.entity.User;

public interface UserService {
	public int addUser(User user);
	public void editUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public List getAllUser();


}
