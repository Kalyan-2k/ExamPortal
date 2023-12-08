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
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorInfo> handleEmail(InvalidEmailException invalidEmailException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(invalidEmailException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorInfo> handlePassword(InvalidPasswordException invalidPasswordException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(invalidPasswordException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidGenderException.class)
	public ResponseEntity<ErrorInfo> handleGender(InvalidGenderException invalidGenderException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(invalidGenderException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> handleUserAlreadyExists(UserAlreadyExistsException userAlreadyExistsException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(userAlreadyExistsException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorInfo> handleName(InvalidNameException invalidNameException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(invalidNameException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<ErrorInfo> handlePasswordMismatch(PasswordMismatchException passwordMismatchException)
	{
        ErrorInfo erroInfo = new ErrorInfo();
        erroInfo.setErrormessage(passwordMismatchException.getMsg());
        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
        erroInfo.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
	}
}
