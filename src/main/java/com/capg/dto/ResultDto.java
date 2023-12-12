package com.capg.dto;

import java.util.List;


public class ResultDto {
	private int resultId;
	private int userId;
	private int testId;
	private List<QuesAnsDto> testQuesAns;
	private int testScore;
	
	public ResultDto() {
	}
	
	public ResultDto(int resultId, int userId, int testId, List<QuesAnsDto> testQuesAns, int testScore) {
		this.resultId = resultId;
		this.userId = userId;
		this.testId = testId;
		this.testQuesAns = testQuesAns;
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

	public List<QuesAnsDto> getTestQuesAns() {
		return testQuesAns;
	}

	public void setTestQuesAns(List<QuesAnsDto> testQuesAns) {
		this.testQuesAns = testQuesAns;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	@Override
	public String toString() {
		return "ResultDto [resultId=" + resultId + ", userId=" + userId + ", testId=" + testId + ", testQuesAns="
				+ testQuesAns + ", testScore=" + testScore + "]";
	}	
	
	
}
