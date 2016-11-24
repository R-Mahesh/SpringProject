package com.model.service;

import java.util.List;

import com.model.entity.Category;

public interface AdminService {
	public int addSupplier(Category category,String s);
	public List getAllCategory();
	public int editCategory(Category category);
	public int deleteCategory(int sp);
	public Category getCategory(int sp);
}
