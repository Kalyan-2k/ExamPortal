package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.entity.Question;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionRepository;

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
}
