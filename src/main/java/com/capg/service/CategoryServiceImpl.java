package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.exceptions.CategoryAlreadyExistsException;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.util.AppConstants;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Category createCategory(Category category) throws CategoryAlreadyExistsException{
		Category existingCategory = categoryRepository.findByCategoryName(category.getCategoryName().toLowerCase());
		if(existingCategory != null) {
			throw new CategoryAlreadyExistsException(AppConstants.CATEGORY_NAME_ALREADY_EXISTS_INFO);
		}
		category.setCategoryName(category.getCategoryName().toLowerCase());
		return categoryRepository.save(category);
	}
	
	public List<Category> fetchCategory(){
		return categoryRepository.findAll();
	}
	
	public Category fetchCategoryById(int cid) throws IdNotFoundException{
		Optional<Category> obj = categoryRepository.findById(cid);
		if(obj.isPresent()) {
			return obj.get();
		}
		else {
			throw new IdNotFoundException(AppConstants.CATEGORY_ID_NOT_FOUND_INFO);
		}
	}
	
	public String deleteCategoryById(int cid) throws IdNotFoundException{
		String msg="";
		if(categoryRepository.existsById(cid))
		{
			categoryRepository.deleteById(cid);
			msg="Category Deleted Successfully";
		}
		else
		{
			throw new IdNotFoundException(AppConstants.CATEGORY_ID_NOT_FOUND_INFO);
		}
		return msg;
	}
	
	public Category updateCategoryById(int cid,Category category) throws IdNotFoundException{
		Category new_category = null;
		if(categoryRepository.existsById(cid)) {
			new_category = categoryRepository.findById(cid).get();
			new_category.setCategoryName(category.getCategoryName().toLowerCase());
			categoryRepository.save(new_category);
		}
		else {
			throw new IdNotFoundException(AppConstants.CATEGORY_ID_NOT_FOUND_INFO);
		}
		return new_category;
	}
}
