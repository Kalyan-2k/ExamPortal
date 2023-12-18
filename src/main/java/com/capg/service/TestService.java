package com.capg.service;

import java.util.List;

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.NameNotFoundException;

public interface TestService {
	public Tests addTest(Tests test);
	public Tests updateTestById(int testId,Tests test)throws IdNotFoundException; 
    public List<Tests> getAllTests();
    public  Tests getTestById(int testId) throws IdNotFoundException;
    public  String  deleteTestByTestId(int testId) throws IdNotFoundException; 
    public Tests getTestByName(String testName) throws NameNotFoundException;
//	public List<Tests> getTestOfCategory(int categoryId)  throws IdNotFoundException;

	
}
