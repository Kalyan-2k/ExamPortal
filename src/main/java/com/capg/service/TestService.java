package com.capg.service;

import java.util.List;

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;

public interface TestService {
	public Tests addTest(Tests test);
	public Tests updateTestById(int testId,Tests test)throws IdNotFoundException; 
    public List<Tests> getAllTests();
    public  Tests getTest(int tId);
    public  String  deleteTestByTestId(int testId) throws IdNotFoundException; 
	public List<Tests> getTestOfCategory(Category cat);
	
}
