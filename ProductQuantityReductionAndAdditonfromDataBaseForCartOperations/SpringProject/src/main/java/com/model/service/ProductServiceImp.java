package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.ProductDao;
import com.model.entity.Products;

import java.util.List;


@Service
public class ProductServiceImp implements ProductService {


	
	@Autowired
	private ProductDao  productDao;	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public int addProducts(Products products, String s) {
		 return productDao.addProducts(products,s);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Products> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int editProducts(Products products) {
		return productDao.editProducts(products);	
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int deleteProducts(int pr) {
		return productDao.deleteProducts(pr);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Products getProducts(int pr) {
		return productDao.getProducts(pr);
	}
	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Products> getProductsByCategory(String id) {
		return productDao.getProductsByCategory(id);
	}
	
	
	

}
