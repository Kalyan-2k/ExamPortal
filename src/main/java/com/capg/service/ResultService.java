package com.capg.service;

import java.util.List;

import com.capg.entity.Result;
import com.capg.exceptions.IdNotFoundException;

public interface ResultService {
	
	public Result insertResult(Result result);
	
	public List<Result> fetchAll();
	
	public List<Result> fetchAllTestsOfOneUser(int userId) throws IdNotFoundException;
}
