package com.capg.exceptions;

public class IdNotFoundException extends Exception{
	String msg;
	public IdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}

}
