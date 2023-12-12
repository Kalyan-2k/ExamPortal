package com.capg.service;

import java.util.List;

import com.capg.entity.Result;

public interface ResultService {
	
	public Result insertResult(Result result);
	
	public List<Result> fetchAll();
}
