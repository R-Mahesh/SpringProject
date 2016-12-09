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
	
	@Transactional
	public int addProducts(Products products, String s) {
		 return productDao.addProducts(products,s);
	}

	@Transactional
	public List getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional
	public int editProducts(Products products) {
		return productDao.editProducts(products);	
	}

	@Transactional
	public int deleteProducts(int pr) {
		return productDao.deleteProducts(pr);
	}

	@Transactional
	public Products getProducts(int pr) {
		return productDao.getProducts(pr);
	}
	
	
	@Transactional
	public List getProductsByCategory(String id) {
		return productDao.getProductsByCategory(id);
	}
	
	
	

}
