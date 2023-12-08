package com.capg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDto {
	private int userId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String confirmPassword;
	private String updateUrl;
	
	public UserDto(){
		
	}
	
	public UserDto(int userId, String firstName, String lastName, String gender, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.updateUrl = "https://localhost:9050/api/v1/user/dashboard/"+this.userId;
	}

	public int getUserId() {
		return this.userId;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getGender() {
		return this.gender;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	
	public void setUserId(int userId) {
		this.userId=userId;
		this.updateUrl = "https://localhost:9050/api/v1/user/dashboard/"+this.userId;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}


	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email
				+ ", updateUrl=" + updateUrl + "]";
	}
	
}
