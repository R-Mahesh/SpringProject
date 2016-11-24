package com.model.dao;

import java.util.List;

import com.model.entity.User;

public interface EmpDao {
public int add(User emp);
public int edit(User emp);
public int delete(int id);
public  User getEmp(int id);
public List getAllEmp();
}
