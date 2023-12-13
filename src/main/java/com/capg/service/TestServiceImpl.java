
package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.TestRepo;
import com.capg.util.AppConstants;
@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestRepo testRepo;
	
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
		return testRepo.save(test);
	}


	public Tests updateTestById(int testId, Tests test) throws IdNotFoundException {
		
		Tests updateTest=null;
		
		if(testRepo.existsById(testId))
		{
			updateTest=testRepo.findById(testId).get();
			test.setTestId(testId);
			return testRepo.save(test);
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
	}

	
	public List<Tests> getAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	public Tests getTest(int testId) {
		// TODO Auto-generated method stub
		return testRepo.findById(testId).get();
	}

	public String deleteTestByTestId(int testId) throws IdNotFoundException{
		if(testRepo.existsById(testId))
		{
			testRepo.deleteById(testId);
			return "Id deleted successfully";
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
	}

	
	public List<Tests> getTestOfCategory(Category category) {
		// TODO Auto-generated method stub
		return testRepo.findByCategory(category);
	}
	
	
}

