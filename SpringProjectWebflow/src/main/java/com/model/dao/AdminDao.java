package com.model.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Category;
import com.model.entity.CategoryEntity;
import com.model.entity.Products;

public interface AdminDao {

public int addSupplier(CategoryEntity categoryEntity); 
public List getAllCategory();
public int editCategory(CategoryEntity categoryEntity);
public int deleteCategory(int sp);
public CategoryEntity getCategory(int sp);
}
