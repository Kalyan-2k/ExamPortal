package com.capg.exceptions;

public class TimeExpiredException extends RuntimeException{
	String msg;
	public TimeExpiredException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}
