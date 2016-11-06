package com.model.service;

import java.util.List;

import com.model.entity.Emp;

public interface EmpService {
	public int add(Emp emp);
	public void edit(Emp s);
	public void delete(int id);
	public Emp getEmp(int id);
	public List getAllEmp();


}
