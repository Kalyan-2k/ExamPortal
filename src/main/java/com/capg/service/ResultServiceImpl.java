package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Result;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.ResultRepository;
import com.capg.util.AppConstants;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	ResultRepository resultRepository;
	
	public Result insertResult(Result result) {
		return resultRepository.save(result);
	}
	
	public List<Result> fetchAll() {
		return resultRepository.findAll();
	}
	
	public List<Result> fetchAllTestsOfOneUser(int userId) throws IdNotFoundException{
		List<Result> result = resultRepository.fetchAllTestsByUserId(userId);
		if( result.size() == 0) {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
		return result;
	}
}
