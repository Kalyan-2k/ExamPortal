package com.capg.exceptions;

public class PasswordMismatchException extends Exception{
	String msg;
	public PasswordMismatchException(String msg) {
		super();
		this.msg=msg;
	}
	public String getMsg() {
		return this.msg;
	}
}
