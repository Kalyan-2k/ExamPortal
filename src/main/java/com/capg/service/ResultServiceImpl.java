package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Result;
import com.capg.repo.ResultRepository;

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
}
