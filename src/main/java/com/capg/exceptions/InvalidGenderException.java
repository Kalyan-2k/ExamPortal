package com.capg.exceptions;

public class InvalidGenderException extends Exception{
	String msg;
	public InvalidGenderException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}

