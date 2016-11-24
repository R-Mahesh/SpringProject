package com.model.dao;

import java.util.List;

import com.model.entity.Category;

public interface AdminDao {

public int addSupplier(Category category,String s); 
public List getAllCategory();
public int editCategory(Category category);
public int deleteCategory(int sp);
public Category getCategory(int sp);
}
