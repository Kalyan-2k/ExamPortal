package com.capg.service;

import java.util.List;

import com.capg.entity.Category;
import com.capg.entity.Test;
import com.capg.exceptions.IdNotFoundException;

public interface TestService {
	public Test addTest(Test test);
	public Test updateTestById(int testId,Test test)throws IdNotFoundException; 
    public List<Test> getAllTests();
    public  Test getTest(int tId);
    public  String  deleteTestByTestId(int testId) throws IdNotFoundException; 
	public List<Test> getTestOfCategory(Category cat);
	
}
