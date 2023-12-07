package com.capg.service;

import java.util.List;

import com.capg.entity.Category;
import com.capg.exceptions.CategoryAlreadyExistsException;
import com.capg.exceptions.IdNotFoundException;


public interface CategoryService {
	
	Category createCategory(Category category) throws CategoryAlreadyExistsException;
	List<Category> fetchCategory();
	Category fetchCategoryById(int id) throws IdNotFoundException;
	String deleteCategoryById(int id) throws IdNotFoundException;
	Category updateCategoryById(int id,Category category)  throws IdNotFoundException;
}
