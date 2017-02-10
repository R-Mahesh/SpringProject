package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.AdminDao;
import com.model.entity.Carousal;
import com.model.entity.CategoryEntity;
@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int addSupplier(CategoryEntity categoryEntity) {
		
		
    return adminDao.addSupplier(categoryEntity);		

	}
	
	

	@Transactional
	public List<CategoryEntity> getAllCategory() {
		return adminDao.getAllCategory();
	}
	
	
	@Transactional
	public int editCategory(CategoryEntity categoryEntity) {
		return adminDao.editCategory(categoryEntity);	
	}

	@Transactional
	public int deleteCategory(int sp) {
		return adminDao.deleteCategory(sp);
		
	}

	@Transactional
	public CategoryEntity getCategory(int sp) {
		return adminDao.getCategory(sp);
	}



	@Transactional
	public int addCarousal(Carousal carousal) {
		return adminDao.addCarousal(carousal);
	}



	@Transactional
	public Carousal getCarousal(int sp) {
		return adminDao.getCarousal(sp);
	}

	

	@Transactional
	public List<Carousal> getCarousalproducts() {
		return adminDao.getCarousalproducts();
	}
	
	
	
	}


