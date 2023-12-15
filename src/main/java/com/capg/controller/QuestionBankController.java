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

import com.capg.entity.QuestionBank;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.NameNotFoundException;
import com.capg.service.QuestionBankService;

@RestController
@RequestMapping("/api/v1")
public class QuestionBankController {

	@Autowired
    private QuestionBankService questionBankService;

    //add questionbank
    @PostMapping("/questionbank")
	public ResponseEntity<QuestionBank> addTest(@RequestBody QuestionBank questionbank)
	{
		return new ResponseEntity <QuestionBank>(questionBankService.addQuestionBank(questionbank), HttpStatus.OK);
	}
    //update questionbank
    @PutMapping("/questionbank/{questionbank_Id}")
    public ResponseEntity<QuestionBank> updateQuestionBankById(@PathVariable("questionbank_Id") int questionbankId,@RequestBody QuestionBank questionbank) throws IdNotFoundException
	{
		return new ResponseEntity<QuestionBank>(questionBankService.updateQuestionBankById(questionbankId,questionbank), HttpStatus.OK);
	}
    //get questionbank
    @GetMapping("/questionbanks")
    public ResponseEntity<List<QuestionBank>> getAllQuestionBanks()
	{
		return new ResponseEntity <List<QuestionBank>>(questionBankService.getAllQuestionBanks(),HttpStatus.OK);
	}    
    
    //get questionBank By Name
    @GetMapping("/questionbank/{questionbank_Name}")
    public ResponseEntity<QuestionBank> getQuestionBankByName(@PathVariable("questionbank_Name") String questionBankName) throws NameNotFoundException
	{
//    	System.out.println(questionBankName);
		return new ResponseEntity<QuestionBank>(questionBankService.getQuestionBankByName(questionBankName), HttpStatus.OK);
	}
    
    //delete questionbank
    @DeleteMapping("/question-bank/{questionbank_Id}")
    public ResponseEntity<String> deleteQuestionBankById(@PathVariable("questionbank_Id") int questionBankId) throws IdNotFoundException
	{
		return new ResponseEntity<String>(questionBankService.deleteQuestionBankById(questionBankId), HttpStatus.OK);
	}
}

