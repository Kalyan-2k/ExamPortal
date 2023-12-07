
package com.capg.service;

import java.util.List;

import com.capg.entity.QuestionBank;
import com.capg.exceptions.IdNotFoundException;

public interface QuestionBankService {
public QuestionBank addQuestionBank(QuestionBank questionbank);
public QuestionBank updateQuestionBankById(int QuestionBankId, QuestionBank questionbank) throws IdNotFoundException ;
public List<QuestionBank> getAllQuestionBanks();
public String deleteQuestionBankById(int QuestionBankId)throws IdNotFoundException;

}
