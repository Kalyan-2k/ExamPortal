package com.capg.exceptions;

public class InvalidNameException extends Exception{
	String msg;
	public InvalidNameException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}
