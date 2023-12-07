package com.capg.exceptions;

public class InvalidPasswordException extends Exception{
	String msg;
	public InvalidPasswordException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}