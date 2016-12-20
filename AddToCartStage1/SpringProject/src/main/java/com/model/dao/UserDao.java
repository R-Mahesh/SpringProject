package com.model.dao;

import java.util.List;

import com.model.entity.User;
import com.model.entity.User_authorization;

public interface UserDao {
public int addUser(User user);
public int editUser(User user);
public int deleteUser(int id);
public  User getUser(int id);
public  List<User> getUserByName(String username);
public List getAllUser();
public int addAuth(User_authorization user_authorization);
}
