package com.capg.util;

public interface AppConstants {

	public static final String CATEGORY_ID_NOT_FOUND_INFO = "THE GIVEN CATEGORY ID DOES NOT EXIST IN THE DATABASE";
	public static final String QUESTION_ID_NOT_FOUND_INFO = "THE GIVEN QUESTION ID DOES NOT EXIST IN THE DATABSE";
	public static final String TEST_ID_NOT_FOUND_INFO = "THE GIVEN TEST ID DOES NOT EXIST IN THE DATABASE";
	public static final String TEST_NAME_NOT_FOUND_INFO = "THE GIVEN TEST NAME DOES NOT EXIST IN THE DATABASE";
	public static final String CATEGORY_NAME_ALREADY_EXISTS_INFO = "THE GIVEN CATEGORY ALREADY EXISTS IN THE DATABASE";
	public static final String USER_INVALID_EMAIL_INFO = "USER NOT FOUND BASED ON GIVEN EMAIL."; 
	public static final String USER_ID_NOT_FOUND_INFO = "ID NOT FOUND, PLEASE ENTER VALID ID";
	public static final String INVALID_PASSWORD_INFO = "password should be of length 8-14 characters consisting of uppercase letters,lowercase letters,digits and ['@','_','#'] symbols only ";
	public static final String INVALID_EMAIL_INFO = "Email should be of type abc.xyz@pqr.com";
    public static final String INVALID_NAME_INFO = "Name should contain alphabets and space";
	public static final String INVALID_GENDER_INFO = "Gender should contains male, female, others as the only options";
	public static final String USERNAME_OR_PASSWORD_MISMATCH = "UserName or Password is Incorrect. Please Try Again"; 
	public static final String PASSWORD_MISMATCH_INFO = "Password and Confirm Password Doesn't match with each other. Please enter same password in both fields";
	public static final String QUESTIONBANK_ID_NOT_FOUND_INFO = "THE GIVEN QUESTIONBANK ID DOES NOT EXIST IN THE DATABASE";
	public static final String QUESTIONBANK_NAME_NOT_FOUND_INFO = "THE GIVEN QUESTIONBANK NAME DOES NOT EXIST IN THE DATABASE";
	public static final String USER_ALREADY_REGISTERED_FOR_TEST_INFO = "THE USER HAS ALREADY REGISTERED FOR THE GIVEN TEST";
	public static final String USER_ALREADY_TAKEN_THE_TEST_INFO = "THE USER HAS ALREADY TAKEN THE TEST BEFORE AND CANNOT TAKE IT AGAIN. KINDLY GO TO YOUR ATTEMPTED TESTS SECTION FROM YOUR DASHBOARD TO VIEW YOUR TEST RESULTS";
	public static final String USER_NOT_REGISTERED_FOR_TEST_INFO = "THE USER HAS NOT REGISTERED FOR THE TEST BEFORE TAKING IT.KINDLY REGISTER FOR THE TEST TO ATTEMPT THE TEST";
	public static final String INVALID_USER_INFO = "CANNOT ACCESS THIS PAGE AS YOU DO NOT HAVE PERMISSION TO ACCESS IT";
	

}
