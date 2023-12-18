package com.capg.exceptions;

public class InvalidUserException extends Exception{
	String msg;
	public InvalidUserException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
