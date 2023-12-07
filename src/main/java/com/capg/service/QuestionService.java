package com.capg.service;

import java.util.List;

import com.capg.entity.Question;
import com.capg.exceptions.IdNotFoundException;

public interface QuestionService {
	Question createQuestion(Question question);
	List<Question> fetchQuestions();
	Question updateQuestionById(int questionId,Question question) throws IdNotFoundException;
	String deleteQuestionById(int questionId) throws IdNotFoundException;
	Question fetchQuestionById(int questionId) throws IdNotFoundException;
}
