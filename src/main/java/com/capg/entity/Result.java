package com.capg.entity;

import java.util.List;
import java.util.Map;

import com.capg.dto.QuestionDto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="result_id")
	private int resultId;
	@Column(name="user_id")
	private int userId;
	@Column(name="test_id")
	private int testId;
	
	@ElementCollection
	@CollectionTable(name = "test_question_answers", joinColumns = @JoinColumn(name = "result_id"))
	private List<QuestionDto> testQuestionAnswers;
	 
	@Column(name="test_score")
	private int testScore;
	
	public Result() {
	}
	
	public Result(int resultId, int userId, int testId, List<QuestionDto> testQuestionAnswers, int testScore) {
		this.resultId = resultId;
		this.userId = userId;
		this.testId = testId;
		this.testQuestionAnswers = testQuestionAnswers;
		this.testScore = testScore;
	}

	
	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public List<QuestionDto> getTestQuestionAnswers() {
		return testQuestionAnswers;
	}

	public void setTestQuestionAnswers(List<QuestionDto> testQuestionAnswers) {
		this.testQuestionAnswers = testQuestionAnswers;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", userId=" + userId + ", testId=" + testId + ", testQuestionAnswers="
				+ testQuestionAnswers + ", testScore=" + testScore + "]";
	}
}
