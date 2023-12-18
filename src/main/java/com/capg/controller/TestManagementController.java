package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.QuestionDto;
import com.capg.dto.ResultDto;
import com.capg.entity.Result;
import com.capg.entity.TestManagement;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidUserException;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.service.TestManagementService;

@RestController
@RequestMapping("/api/v1")
public class TestManagementController {

	@Autowired
	TestManagementService testManagementService;
	
	
	@PostMapping("/user/register/test")
	public ResponseEntity<TestManagement> registerTest(@RequestBody TestManagement testManagement) throws UserAlreadyExistsException
	{
		return new ResponseEntity <TestManagement>(testManagementService.registerTest(testManagement), HttpStatus.OK);
	}
	
	@GetMapping("/user/take/test/{userId}/{testId}")
	public ResponseEntity<List<QuestionDto>> takeTest(@PathVariable("userId") int userId,@PathVariable("testId") int testId) throws IdNotFoundException,UserAlreadyExistsException,InvalidUserException{
		return new ResponseEntity<List<QuestionDto>>(testManagementService.takeTest(userId,testId),HttpStatus.OK);
	}
	
	@PutMapping("/submit/test/{userId}/{testId}")
	public ResponseEntity<ResultDto> submitTest(@PathVariable("userId") int userId,@PathVariable("testId") int testId,@RequestBody Result result){
		return new ResponseEntity<ResultDto>(testManagementService.submitTest(userId,testId,result.getTestQuestionAnswers()),HttpStatus.OK);
	}
	
}
