package com.capg.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.entity.User;
import com.capg.repo.UserRepo;

public class AdminDto {
	
	private int adminId;
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private String gender;
	private Map<String,String> profileUrls;
	private Map<String,String> categoryUrls;
	private Map<String,String> questionUrls;
	private Map<String,String> questionBankUrls;
	private Map<String,String> testUrls;
	
	
	public AdminDto() {
		categoryUrls = new HashMap<>();
		
		categoryUrls.put("Add Category Url","localhost:9050/api/v1/admin/category");
		categoryUrls.put("Show All Categories Url","localhost:9050/api/v1/admin/category");
		categoryUrls.put("Update Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		categoryUrls.put("Delete Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		categoryUrls.put("Get Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		
		questionBankUrls = new HashMap<>();
		
		questionBankUrls.put("Add QuestionBank Url", "localhost:9050/api/v1/admin/questionbank");
		questionBankUrls.put("Show All QuestionBanks Url", "localhost:9050/api/v1/admin/questionbanks");
		questionBankUrls.put("Get QuestionBank By Id Url", "localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		questionBankUrls.put("Update QuestionBank By Id Url","localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		questionBankUrls.put("Delete QuestionBank By Id Url","localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		
		questionUrls = new HashMap<>();
		
		questionUrls.put("Add Question Url","localhost:9050/api/v1/admin/question");
		questionUrls.put("Show All Questions Url","localhost:9050/api/v1/admin/question");
		questionUrls.put("Get Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		questionUrls.put("Update Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		questionUrls.put("Delete Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		
		testUrls = new HashMap<>();
		
		testUrls.put("Add Test Url","localhost:9050/api/v1/admin/test");
		testUrls.put("Show All Tests Url","localhost:9050/api/v1/tests");
		testUrls.put("Get Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
		testUrls.put("Update Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
		testUrls.put("Delete Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
	}

	public AdminDto(int adminId,User user) {
		this.adminId = adminId;
		firstName = user.getFirstName();
		lastName = user.getLastName();
		gender = user.getGender();
		role = user.getRole();
		email = user.getEmail();

		profileUrls = new HashMap<>();
		
		profileUrls.put("Update Admin Profile Url","localhost:9050/api/v1/admin/dashboard/"+this.adminId);
		profileUrls.put("Reset Password Url","localhost:9050/api/v1/resetPassword/"+this.adminId);
		categoryUrls = new HashMap<>();
		
		categoryUrls.put("Add Category Url","localhost:9050/api/v1/admin/category");
		categoryUrls.put("Show All Categories Url","localhost:9050/api/v1/admin/category");
		categoryUrls.put("Update Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		categoryUrls.put("Delete Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		categoryUrls.put("Get Category By Id Url","localhost:9050/api/v1/admin/category/{categoryId}");
		
		questionBankUrls = new HashMap<>();
		
		questionBankUrls.put("Add QuestionBank Url", "localhost:9050/api/v1/admin/questionbank");
		questionBankUrls.put("Show All QuestionBanks Url", "localhost:9050/api/v1/admin/questionbanks");
		questionBankUrls.put("Get QuestionBank By Id Url", "localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		questionBankUrls.put("Update QuestionBank By Id Url", "localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		questionBankUrls.put("Delete QuestionBank By Id Url", "localhost:9050/api/v1/admin/questionbank/{questionbankId}");
		
		questionUrls = new HashMap<>();
		
		questionUrls.put("Add Question Url","localhost:9050/api/v1/admin/question");
		questionUrls.put("Show All Questions Url","localhost:9050/api/v1/admin/question");
		questionUrls.put("Get Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		questionUrls.put("Update Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		questionUrls.put("Delete Question By Id Url","localhost:9050/api/v1/admin/question/{questionId}");
		
		testUrls = new HashMap<>();
		
		testUrls.put("Add Test Url","localhost:9050/api/v1/admin/test");
		testUrls.put("Show All Tests Url","localhost:9050/api/v1/tests");
		testUrls.put("Get Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
		testUrls.put("Update Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
		testUrls.put("Delete Test By Id Url","localhost:9050/api/v1/admin/test/{testId}");
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Map<String, String> getCategoryUrls() {
		return categoryUrls;
	}

	public void setCategoryUrls(Map<String, String> categoryUrls) {
		this.categoryUrls = categoryUrls;
	}

	public Map<String, String> getQuestionUrls() {
		return questionUrls;
	}

	public void setQuestionUrls(Map<String, String> questionUrls) {
		this.questionUrls = questionUrls;
	}

	public Map<String, String> getQuestionBankUrls() {
		return questionBankUrls;
	}

	public void setQuestionBankUrls(Map<String, String> questionBankUrls) {
		this.questionBankUrls = questionBankUrls;
	}

	public Map<String, String> getTestUrls() {
		return testUrls;
	}

	public void setTestUrls(Map<String, String> testUrls) {
		this.testUrls = testUrls;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Map<String, String> getProfileUrls() {
		return profileUrls;
	}

	public void setProfileUrls(Map<String, String> profileUrls) {
		this.profileUrls = profileUrls;
	}

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", email=" + email + ", gender=" + gender + ", profileUrls=" + profileUrls + ", categoryUrls="
				+ categoryUrls + ", questionUrls=" + questionUrls + ", questionBankUrls=" + questionBankUrls
				+ ", testUrls=" + testUrls  + "]";
	}

	
}
