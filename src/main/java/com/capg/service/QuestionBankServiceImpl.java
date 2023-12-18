package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.QuestionBankDto;
import com.capg.entity.Category;
import com.capg.entity.Question;
import com.capg.entity.QuestionBank;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.NameNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionBankRepo;
import com.capg.repo.QuestionRepository;
import com.capg.util.AppConstants;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	QuestionBankRepo questionBankRepo;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public QuestionBank addQuestionBank(QuestionBank questionBank) {
//		System.out.println(questionBank);
//		System.out.println(questionBank.getCategory());
		Category category=null;
		System.out.println(questionBank.getCategory());
		int category_id = questionBank.getCategory().getCategoryId();
		if(categoryRepository.existsById(category_id)) {
			category = categoryRepository.findById(category_id).get();
			System.out.println("Fetching Category: \n"+category);
			questionBank.setCategory(category);
		}
		return questionBankRepo.save(questionBank);
//		return questionBank;
	}

	@Override
	public QuestionBank updateQuestionBankById(int QuestionBankId, QuestionBank questionbank)throws IdNotFoundException
	
	{
		
		QuestionBank updateQuestionBankById=null;
		
		if(questionBankRepo.existsById(QuestionBankId))
		{
			updateQuestionBankById=questionBankRepo.findById(QuestionBankId).get();
			questionbank.setQuestionBankId(QuestionBankId);
			return questionBankRepo.save(questionbank);
		}
		else
		{
			throw new IdNotFoundException(AppConstants.QUESTIONBANK_ID_NOT_FOUND_INFO);
		}
		
	}

	public List<QuestionBank> getAllQuestionBanks() 
	{
	
		return questionBankRepo.findAll();
	}
		
	public QuestionBank getQuestionBankByName(String questionBankName) throws NameNotFoundException
	{

//		System.out.println(questionBankName);
		if(questionBankRepo.existsByQuestionBankName(questionBankName))
		{
			return questionBankRepo.getQuestionBankByName(questionBankName);
//				System.out.println(questionBankRepo.getQuestionBankByName(questionBankName));
//				msg="Id deleted successfully";
		}
		else
		{
			throw new NameNotFoundException(AppConstants.QUESTIONBANK_NAME_NOT_FOUND_INFO);
		}
	}		

		
	public String deleteQuestionBankById(int QuestionBankId) throws IdNotFoundException
		{
		
			String msg;
			if(questionBankRepo.existsById(QuestionBankId))
			{
				questionBankRepo.deleteById(QuestionBankId);
				msg="Id deleted successfully";
			}
			else
			{
				throw new IdNotFoundException(AppConstants.QUESTIONBANK_ID_NOT_FOUND_INFO);
			}
			
			return msg;
		}

	public QuestionBankDto getQuestionBankWithQuestions(String questionBankName) throws NameNotFoundException {
		if(questionBankRepo.existsByQuestionBankName(questionBankName)) {
			QuestionBank questionBank = questionBankRepo.getQuestionBankByName(questionBankName);
			List<Question> questions = questionRepository.fetchQuestionsOfCategory(questionBank.getCategory().getCategoryId());
			QuestionBankDto questionBankDto = new QuestionBankDto();
			questionBankDto.setQuestionBankId(questionBank.getQuestionBankId());
			questionBankDto.setQuestionBankName(questionBank.getQuestionBankName());
			questionBankDto.setQuestions(questions);
			return questionBankDto;
		
		}else
		{
			throw new NameNotFoundException(AppConstants.QUESTIONBANK_NAME_NOT_FOUND_INFO);
		}
	}
}
