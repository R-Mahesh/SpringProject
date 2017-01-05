package com.model.service;

import java.util.List;

import com.model.entity.Products;

public interface ProductService {
	
	public int addProducts(Products products,String s);
	public List<Products> getAllProducts();
	public int editProducts(Products products);
	public int deleteProducts(int pr);
	public Products getProducts(int pr);
	public List<Products> getProductsByCategory(String id);

	}
