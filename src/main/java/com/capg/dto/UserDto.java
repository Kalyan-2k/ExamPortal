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
	
	private String updateProfileUrl;
	private String registerTestUrl;
	private String findActiveTestsUrl;
	private String resetPassowordUrl;
	private String checkTestResultUrl;
	
	public UserDto(){
		
	}
	
	public UserDto(int userId, String firstName, String lastName, String gender, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		
		this.updateProfileUrl = "localhost:9050/api/v1/user/dashboard/"+this.userId;
		this.resetPassowordUrl = "localhost:9050/api/v1/resetPassword/"+this.userId;
		this.registerTestUrl = "localhost:9050/api/v1/user/register/test";
		this.findActiveTestsUrl = "localhost:9050/api/v1/tests";
		this.checkTestResultUrl = "localhost:9050/api/v1/result/"+this.userId;
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
		this.updateProfileUrl = "localhost:9050/api/v1/user/dashboard/"+this.userId;
		this.resetPassowordUrl = "localhost:9050/api/v1/resetPassword/"+this.userId;
		this.checkTestResultUrl = "localhost:9050/api/v1/result/"+this.userId;
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
	
	public String getUpdateProfileUrl() {
		return updateProfileUrl;
	}

	public void setUpdateProfileUrl(String updateUrl) {
		this.updateProfileUrl = updateUrl;
	}
	
	public String getRegisterTestUrl() {
		return registerTestUrl;
	}

	public void setRegisterTestUrl(String registerTestUrl) {
		this.registerTestUrl = registerTestUrl;
	}

	public String getFindActiveTestsUrl() {
		return findActiveTestsUrl;
	}

	public void setFindActiveTestsUrl(String findActiveTestsUrl) {
		this.findActiveTestsUrl = findActiveTestsUrl;
	}

	public String getResetPassowordUrl() {
		return resetPassowordUrl;
	}

	public void setResetPassowordUrl(String resetPassowordUrl) {
		this.resetPassowordUrl = resetPassowordUrl;
	}

	public String getCheckTestResultUrl() {
		return checkTestResultUrl;
	}

	public void setCheckTestResultUrl(String checkTestResultUrl) {
		this.checkTestResultUrl = checkTestResultUrl;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", updateProfileUrl=" + updateProfileUrl + ", registerTestUrl=" + registerTestUrl
				+ ", findActiveTestsUrl=" + findActiveTestsUrl + ", resetPassowordUrl=" + resetPassowordUrl
				+ ", checkTestResultUrl=" + checkTestResultUrl + "]";
	}

	
	
}
