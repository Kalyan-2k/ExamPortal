package com.capg.exceptions;

public class CategoryAlreadyExistsException extends Exception{
	String msg;
	public CategoryAlreadyExistsException(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return this.msg;
	}
}
