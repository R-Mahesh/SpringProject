package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.AdminDao;
import com.model.entity.Category;
@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int addSupplier(Category category,String s) {
		
		
    return adminDao.addSupplier(category,s);		

	}
	
	

	@Transactional
	public List getAllCategory() {
		return adminDao.getAllCategory();
	}
	
	
	@Transactional
	public int editCategory(Category category) {
		return adminDao.editCategory(category);	
	}

	@Transactional
	public int deleteCategory(int sp) {
		return adminDao.deleteCategory(sp);
		
	}

	@Transactional
	public Category getCategory(int sp) {
		return adminDao.getCategory(sp);
	}
	
	
	
	}


