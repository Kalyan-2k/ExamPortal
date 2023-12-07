package com.capg.exceptions;

public class UserAlreadyExistsException extends Exception{
	String msg;
	public UserAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}