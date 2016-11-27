package com.model.dao;

import java.util.List;

import com.model.entity.User;

public interface UserDao {
public int addUser(User user);
public int editUser(User user);
public int deleteUser(int id);
public  User getUser(int id);
public List getAllUser();
}
