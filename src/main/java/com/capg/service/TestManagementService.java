package com.capg.service;

import java.util.List;

import com.capg.dto.QuestionDto;
import com.capg.dto.ResultDto;
import com.capg.entity.TestManagement;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidUserException;
import com.capg.exceptions.UserAlreadyExistsException;

public interface TestManagementService {

	public TestManagement registerTest(TestManagement testManagement) throws UserAlreadyExistsException;
	public List<QuestionDto> takeTest(int userId,int testId) throws IdNotFoundException,UserAlreadyExistsException,InvalidUserException;
	public ResultDto submitTest(int userId,int testId,List<QuestionDto> testQuestionAnswers);

}

