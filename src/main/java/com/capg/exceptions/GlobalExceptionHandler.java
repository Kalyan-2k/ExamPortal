package com.capg.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@RestControllerAdvice
 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleEmail(IdNotFoundException idNotFoundException)
	{
	            ErrorInfo erroInfo = new ErrorInfo();
	            erroInfo.setErrormessage(idNotFoundException.getMsg());
	            erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	            erroInfo.setLocalDateTime(LocalDateTime.now());
	            return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> handleCategory(CategoryAlreadyExistsException categoryAlreadyExistsException)
	{
	            ErrorInfo erroInfo = new ErrorInfo();
	            erroInfo.setErrormessage(categoryAlreadyExistsException.getMsg());
	            erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	            erroInfo.setLocalDateTime(LocalDateTime.now());
	            return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
}
