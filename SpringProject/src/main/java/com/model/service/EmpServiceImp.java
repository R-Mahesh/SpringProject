package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.EmpDao;
import com.model.entity.Emp;
@Service("empService")
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpDao empDao;
	@Transactional
	public int add(Emp emp) {
return empDao.add(emp);		
	}

	@Transactional
	public void edit(Emp emp) {
		empDao.edit(emp);	
	}

	@Transactional
	public void delete(int id) {
		empDao.delete(id);
		
	}

	@Transactional
	public Emp getEmp(int id) {
		return empDao.getEmp(id);
	}

	@Transactional
	public List getAllEmp() {
		return empDao.getAllEmp();
	}

}
