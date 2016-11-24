package com.model.service;

import java.util.List;

import com.model.entity.Category;
import com.model.entity.User;

public interface EmpService {
	public int add(User emp);
	public void edit(User s);
	public void delete(int id);
	public User getEmp(int id);
	public List getAllEmp();


}
