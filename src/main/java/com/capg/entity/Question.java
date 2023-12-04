package com.capg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_id;
	
	@Column(name="question_name")
	private String questionName;
	
	@Column(name="option_1")
	private String option1;

	@Column(name="option_2")
	private String option2	;
	
	@Column(name="option_3")
	private String option3;
	
	@Column(name="option_4")
	private String option4;

	@Column(name="crct_answer")
	private String crctAnswer;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="category_id", referencedColumnName = "category_id")
	@JsonBackReference(value = "category_id")
    private Category category;
	
	@Column(name="is_active")
	private boolean isActive = true;

	public Question() {
	}

	public Question(String questionName, String option1, String option2, String option3, String option4,
			String crctAnswer, Category category, boolean isActive) {
		this.questionName = questionName;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.crctAnswer = crctAnswer;
		this.category = category;
		this.isActive = isActive;
	}



	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", questionName=" + questionName + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", crctAnswer="
				+ crctAnswer + ", category=" + category + ", isActive=" + isActive + "]";
	}
	
	
}


