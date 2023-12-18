package com.capg.exceptions;

public class InvalidTestNameException extends Exception{
	String msg;
	public InvalidTestNameException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
