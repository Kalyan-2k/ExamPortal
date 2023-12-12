package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Result;
import com.capg.service.ResultService;

@RestController
@RequestMapping("/api/v1")
public class ResultController {
	@Autowired
	ResultService resultService;
	
	@PostMapping("/result")
	public ResponseEntity<Result> addResult(@RequestBody Result result){
		return new ResponseEntity<Result>(resultService.insertResult(result),HttpStatus.OK);
	}
	@GetMapping("/result/all")
	public ResponseEntity<List<Result>> fetchAllResults(){
		return new ResponseEntity<List<Result>>(resultService.fetchAll(),HttpStatus.OK);
	}
}
