package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.entity.Question;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionRepository;
import com.capg.util.AppConstants;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Question createQuestion(Question question) {
		Category category=null;
		System.out.println(question.getCategory());
		int category_id = question.getCategory().getCategoryId();
		if(categoryRepository.existsById(category_id)) {
			category = categoryRepository.findById(category_id).get();
			System.out.println("Fetching Category: \n"+category);
			question.setCategory(category);
		}
		return questionRepository.save(question);
//		return question;
	}
	public List<Question> fetchQuestions(){
		return questionRepository.findAll();
	}
	
	public Question updateQuestionById(int questionId,Question question) throws IdNotFoundException{
		Question updateQuestion = null;
		if(questionRepository.existsById(questionId)) {
			updateQuestion = questionRepository.findById(questionId).get();
			updateQuestion.setQuestionName(question.getQuestionName());
			updateQuestion.setOption1(question.getOption1());
			updateQuestion.setOption2(question.getOption2());
			updateQuestion.setOption3(question.getOption3());
			updateQuestion.setOption4(question.getOption4());
			updateQuestion.setCrctAnswer(question.getCrctAnswer());
			updateQuestion.setIsActive(question.getIsActive());
			return questionRepository.save(updateQuestion);
		}else {
			throw new IdNotFoundException(AppConstants.QUESTION_ID_NOT_FOUND_INFO);
		}
	}
	
	public String deleteQuestionById(int questionId) throws IdNotFoundException{
		if(questionRepository.existsById(questionId)) {
			questionRepository.deleteById(questionId);
			return "Question Deleted Successfully";
		}else {
			throw new IdNotFoundException(AppConstants.QUESTION_ID_NOT_FOUND_INFO);
		}
	}
	
	public Question fetchQuestionById(int questionId) throws IdNotFoundException {
		if(questionRepository.existsById(questionId)) {
			return questionRepository.findById(questionId).get();
		}else {
			throw new IdNotFoundException(AppConstants.QUESTION_ID_NOT_FOUND_INFO);
		}
	}
}
