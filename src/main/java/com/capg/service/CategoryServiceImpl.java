package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> fetchCategory(){
		return categoryRepository.findAll();
	}
	
	public Category fetchCategoryById(int cid) {
		Optional<Category> obj = categoryRepository.findById(cid);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}
	
	public String deleteCategoryById(int cid) {
		String msg="";
		if(categoryRepository.existsById(cid))
		{
			categoryRepository.deleteById(cid);
			msg="Category Deleted Successfully";
		}
//		else
//		{
//			throw new IdNotFoundException(AppConstant.PRODUCT_ID_NOT_FOUND_INFO);
//		}
		return msg;
	}
	
	public Category updateCategoryById(int cid,Category category) {
		Category new_category = null;
		if(categoryRepository.existsById(cid)) {
			new_category = categoryRepository.findById(cid).get();
			new_category.setCategoryName(category.getCategoryName());
			categoryRepository.save(new_category);
		}
		return new_category;
	}
}
