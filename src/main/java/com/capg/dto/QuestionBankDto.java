package com.capg.dto;

import java.util.List;

import com.capg.entity.Question;

public class QuestionBankDto {

	private int questionBankId;
	private String questionBankName;
	private List<Question> questions;
	public QuestionBankDto() {
	}
	public QuestionBankDto(int questionBankId, String questionBankName, List<Question> questions) {
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
		this.questions = questions;
	}
	public int getQuestionBankId() {
		return questionBankId;
	}
	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}
	public String getQuestionBankName() {
		return questionBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "QuestionBankDto [questionBankId=" + questionBankId + ", questionBankName=" + questionBankName
				+ ", questions=" + questions + "]";
	}
	
	
}
