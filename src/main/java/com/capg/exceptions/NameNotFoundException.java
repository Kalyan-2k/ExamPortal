package com.capg.exceptions;

public class NameNotFoundException extends Exception{

	String msg;
	public NameNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
