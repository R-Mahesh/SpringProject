package com.model.dao;

import java.util.List;

import com.model.entity.Emp;

public interface EmpDao {
public int add(Emp emp);
public int edit(Emp emp);
public int delete(int id);
public Emp getEmp(int id);
public List getAllEmp();
}
