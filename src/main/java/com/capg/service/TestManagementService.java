package com.capg.service;

import java.util.List;

import com.capg.dto.QuestionDto;
import com.capg.dto.ResultDto;
import com.capg.entity.TestManagement;
import com.capg.exceptions.IdNotFoundException;

public interface TestManagementService {

	public TestManagement registerTest(TestManagement testManagement);
	public List<QuestionDto> takeTest(int userId,int testId) throws IdNotFoundException;
	public ResultDto submitTest(int userId,int testId,List<QuestionDto> testQuestionAnswers);

}

