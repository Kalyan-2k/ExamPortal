package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Question;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.QuestionService;

@RestController
@RequestMapping("api/v1")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@PostMapping("/question")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return new ResponseEntity<Question>(questionService.createQuestion(question), HttpStatus.OK);
	}
	
	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions(){
		return new ResponseEntity<List<Question>>(questionService.fetchQuestions(),HttpStatus.OK);
	}
	
	@PutMapping("/question/{questionId}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("questionId") int questionId,@RequestBody Question question) throws IdNotFoundException{
		return new ResponseEntity<Question>(questionService.updateQuestionById(questionId, question),HttpStatus.OK);
	}
	
	@DeleteMapping("/question/{questionId}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("questionId") int questionId) throws IdNotFoundException{
		return new ResponseEntity<String>(questionService.deleteQuestionById(questionId),HttpStatus.OK);
	}
	
	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("questionId") int questionId) throws IdNotFoundException{
		return new ResponseEntity<Question>(questionService.fetchQuestionById(questionId),HttpStatus.OK);
	}
}
