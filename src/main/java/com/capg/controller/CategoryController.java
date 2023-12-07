package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Category;
import com.capg.exceptions.CategoryAlreadyExistsException;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)throws CategoryAlreadyExistsException{
		return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategory(){
		return new ResponseEntity<List<Category>>(categoryService.fetchCategory(), HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Category> getOneCategory(@PathVariable("categoryId") int cid) throws IdNotFoundException{
		return new ResponseEntity<Category>(categoryService.fetchCategoryById(cid),HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int cid) throws IdNotFoundException{
		return new ResponseEntity<String>(categoryService.deleteCategoryById(cid),HttpStatus.OK);
	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") int cid,@RequestBody Category category)  throws IdNotFoundException{
		return new ResponseEntity<Category>(categoryService.updateCategoryById(cid,category),HttpStatus.OK);
	}
}
