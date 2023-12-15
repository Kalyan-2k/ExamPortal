package com.capg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="questionbank")
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="questionbank_Id")
	private int questionBankId;
	
	@Column(name="questionbank_Name")
	private String questionBankName;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="category_id",referencedColumnName="category_id")
	@JsonBackReference(value="category_id")
	private Category category;
	
	public QuestionBank()
	{
		
	}
	
	public QuestionBank(int questionBankId, String questionBankName) {
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
	}

	public QuestionBank(int questionBankId, String questionBankName) {
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
	}


	public QuestionBank(int questionBankId, String questionBankName, Category category) {
		this.questionBankId = questionBankId;
		this.questionBankName = questionBankName;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QuestionBank [questionBankId=" + questionBankId + ", questionBankName=" + questionBankName
				+ ", category=" + category.getCategoryId() + "]";
	}
		
}