
package com.capg.service;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.NameNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.TestRepo;
import com.capg.util.AppConstants;
@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestRepo testRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	
	public Tests addTest(Tests test) {
		
		Category category=null;
		System.out.println(test.getCategory());
		int category_id = test.getCategory().getCategoryId();
		if(categoryRepository.existsById(category_id)) {
			category = categoryRepository.findById(category_id).get();
			System.out.println("Fetching Category: \n"+category);
			test.setCategory(category);
		}
	
		return testRepository.save(test);
	}


	public Tests updateTestById(int testId, Tests test) throws IdNotFoundException {
		
		Tests updateTest=null;
		
		if(testRepository.existsById(testId))
		{
			updateTest=testRepository.findById(testId).get();
			test.setTestId(testId);
			return testRepository.save(test);
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
	}

	
	public List<Tests> getAllTests() {
		// TODO Auto-generated method stub
		return testRepository.findAllTestsActive();
	}


	public Tests getTestById(int testId) throws IdNotFoundException{

		// TODO Auto-generated method stub
		Tests test = testRepository.findById(testId).get(); 
		System.out.println(test);
		if(test == null) {
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}else {
			return test;
		}
	}

	public String deleteTestByTestId(int testId) throws IdNotFoundException{
		if(testRepository.existsById(testId))
		{
			testRepository.deleteById(testId);
			return "Id deleted successfully";
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
	}	
	
	public Tests getTestByName(String testName) throws NameNotFoundException {
		Tests test = testRepository.findTestByName(testName);
		if(test == null) {
			throw new NameNotFoundException(AppConstants.TEST_NAME_NOT_FOUND_INFO);
		}else {
			return test;
		}
		
	}
}

