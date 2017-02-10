package com.model.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class CategoryEntity {

	public CategoryEntity(){}
	
/**
	 * 
	 */
	 public void addProducts(Products products) {
	        this.products.add(products);
	       /* if (products.getCategories() != this) {
	        	products.setCategories(this);
	        }*/
	    }
	
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int categoryId;
private String categoryName;
@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@Fetch(FetchMode.JOIN)
private List<Products> products;

public CategoryEntity(int categoryId, String categoryName, List<Products> products) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.products = products;
}
public List<Products> getProducts() {
	return products;
}
public void setProducts(List<Products> list) {
	this.products = list;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
}