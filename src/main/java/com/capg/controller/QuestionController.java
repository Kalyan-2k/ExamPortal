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

import com.capg.entity.Question;
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
}
