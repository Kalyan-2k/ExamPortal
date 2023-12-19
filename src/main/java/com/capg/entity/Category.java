package com.capg.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToOne(mappedBy="category",cascade = CascadeType.ALL)
	@JsonManagedReference(value="category_id")
	private QuestionBank questionBank;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "category_id")
	private List<Question> questions = new ArrayList<>();
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "category_id")
	private List<Tests> test= new ArrayList<>();
	
	public List<Tests> getTest() {
		return test;
	}

	public void setTest(List<Tests> tests) {
		this.test = tests;
	}

	public Category() 
	{
	
	}
	
	public Category(int categoryId, String categoryName,QuestionBank questionBank,List<Question> questions,List<Tests> test) {

		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.questionBank = questionBank;
		this.questions = questions;
		this.test = test;
	}


	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", Questions="+ questions +", test="+test+"]";
	}
	
}
