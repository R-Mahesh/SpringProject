package com.model.service;

import java.util.List;

/*import com.model.entity.Category;*/
import com.model.entity.CategoryEntity;
import com.model.entity.Products;

public interface AdminService {
	public int addSupplier(CategoryEntity categoryEntity);
	public List<CategoryEntity> getAllCategory();
	public int editCategory(CategoryEntity categoryEntity);
	public int deleteCategory(int sp);
	public CategoryEntity getCategory(int sp);
}
