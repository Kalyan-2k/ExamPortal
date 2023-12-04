package com.capg.service;

import java.util.List;

import com.capg.entity.Category;


public interface CategoryService {
	
	Category createCategory(Category category);
	List<Category> fetchCategory();
}
