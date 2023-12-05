package com.capg.service;

import java.util.List;

import com.capg.entity.Question;

public interface QuestionService {
	Question createQuestion(Question question);
	List<Question> fetchQuestions();
}
