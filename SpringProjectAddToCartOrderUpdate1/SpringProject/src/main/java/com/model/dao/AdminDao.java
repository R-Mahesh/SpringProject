package com.model.dao;

import java.util.List;

import com.model.entity.Carousal;
import com.model.entity.CategoryEntity;

public interface AdminDao {

public int addSupplier(CategoryEntity categoryEntity); 
public List<CategoryEntity> getAllCategory();
public int editCategory(CategoryEntity categoryEntity);
public int deleteCategory(int sp);
public CategoryEntity getCategory(int sp);
public int addCarousal(Carousal carousal);
public Carousal getCarousal(int sp);
public List<Carousal> getCarousalproducts();
}
