package com.model.dao;

import com.model.entity.Products;

import java.util.List;

import com.model.entity.Products;

public interface ProductDao {
	
	public int addProducts(Products products,String s);
	public List<Products> getAllProducts();
	public int editProducts(Products products);
	public int deleteProducts(int pr);
	public Products getProducts(int pr);
	public List<Products> getProductsByCategory(String id);


}