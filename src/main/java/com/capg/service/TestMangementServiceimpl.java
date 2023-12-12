package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.QuesAnsDto;
import com.capg.dto.QuestionDto;
import com.capg.dto.ResultDto;
import com.capg.entity.Question;
import com.capg.entity.Result;
import com.capg.entity.Test;
import com.capg.entity.TestManagement;
import com.capg.entity.User;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.QuestionRepository;
import com.capg.repo.ResultRepository;
import com.capg.repo.TestManagementRepo;
import com.capg.repo.TestRepo;
import com.capg.repo.UserRepo;
import com.capg.util.AppConstants;

@Service
public class TestMangementServiceimpl implements TestManagementService{

	
	@Autowired
	TestManagementRepo testManagementRepo;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	TestRepo testRepository;
	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	UserRepo userRepository;
	
	@Override
	public TestManagement registerTest(TestManagement testManagement) {
		
		return testManagementRepo.save(testManagement);
	}


	public List<QuestionDto> takeTest(int userId, int testId) throws IdNotFoundException{
		Result result=resultRepository.findByUserIdAndTestId(userId,testId);
		if (result !=null) {
			return null; //need to update to exception code for test already taken user
		}else {
			Optional<User> user=userRepository.findById((long)userId);
			if(user.isPresent()) {
				Optional<Test> test=testRepository.findById(testId);
				if(test.isPresent()) {
					Result newResult=new Result();
					newResult.setUserId(user.get().getUserId());
					newResult.setTestId(test.get().getTestId());
					List<Question> questions=questionRepository.fetchQuestionsAtRandom(test.get().getCategory().getCategoryId(),test.get().getNoOfQuestions());
					List<QuestionDto> questionsDto = new ArrayList<>();
					for(Question question:questions) {
						QuestionDto questionDto = new QuestionDto();
						questionDto.setQuestionName(question.getQuestionName());
						questionDto.setOption1(question.getOption1());
						questionDto.setOption2(question.getOption2());
						questionDto.setOption3(question.getOption3());
						questionDto.setOption4(question.getOption4());
						questionDto.setCrctAnswer(question.getCrctAnswer());
//						questionDto.setAnswer(null);
						questionsDto.add(questionDto);
					}
					newResult.setTestQuestionAnswers(questionsDto);
					resultRepository.save(newResult);
					return questionsDto;
				}else {
					throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
				}
			}else {
				throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
			}
		}
	}
	
	public ResultDto submitTest(int userId,int testId,List<QuestionDto> testQuestionAnswers) {
		Result result=resultRepository.findByUserIdAndTestId(userId, testId);
		int size=result.getTestQuestionAnswers().size();
		int score=0;
		for(int index=0;index<size;index++) {
			if (result.getTestQuestionAnswers().get(index).getCrctAnswer().equals(testQuestionAnswers.get(index).getAnswer())) {
				result.getTestQuestionAnswers().get(index).setScore(1);
				result.getTestQuestionAnswers().get(index).setAnswer(testQuestionAnswers.get(index).getAnswer());
				result.setTestScore(++score);
			}
			else {
				result.getTestQuestionAnswers().get(index).setAnswer(testQuestionAnswers.get(index).getAnswer());
				result.getTestQuestionAnswers().get(index).setScore(0);
			}
		}
		List<QuesAnsDto> resultQuestions=new ArrayList<>();
		for(QuestionDto question: result.getTestQuestionAnswers()) {
			QuesAnsDto qad = new QuesAnsDto();
			qad.setQuestionName(question.getQuestionName());
			qad.setOption1(question.getOption1());
			qad.setOption2(question.getOption2());
			qad.setOption3(question.getOption3());
			qad.setOption4(question.getOption4());
			qad.setCrctAnswer(question.getCrctAnswer());
			qad.setAnswer(question.getAnswer());
			qad.setScore(question.getScore());
			resultQuestions.add(qad);
		}
		resultRepository.save(result);
		ResultDto resultDto=new ResultDto();
		resultDto.setResultId(result.getResultId());
		resultDto.setUserId(result.getUserId());
		resultDto.setTestId(result.getTestId());
		resultDto.setTestScore(result.getTestScore());
		resultDto.setTestQuesAns(resultQuestions);
		
		return resultDto;
	}
}
