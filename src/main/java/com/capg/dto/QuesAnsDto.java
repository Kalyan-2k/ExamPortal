package com.capg.dto;

public class QuesAnsDto {
	
	private String questionName;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String crctAnswer;
	private String answer="";   //user given answer while taking the test
	private int score;
	
	public QuesAnsDto() {
	}

	public QuesAnsDto(String questionName, String option1, String option2, String option3, String option4,
			String crctAnswer, String answer, int score) {
		this.questionName = questionName;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.crctAnswer = crctAnswer;
		this.answer = answer;
		this.score = score;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCrctAnswer() {
		return crctAnswer;
	}

	public void setCrctAnswer(String crctAnswer) {
		this.crctAnswer = crctAnswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "QuesAnsDto [questionName=" + questionName + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", crctAnswer=" + crctAnswer + ", answer=" + answer
				+ ", score=" + score + "]";
	}
	
}
