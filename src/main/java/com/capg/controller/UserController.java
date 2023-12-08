package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.UserDto;
import com.capg.entity.User;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidEmailException;
import com.capg.exceptions.InvalidGenderException;
import com.capg.exceptions.InvalidNameException;
import com.capg.exceptions.InvalidPasswordException;
import com.capg.exceptions.PasswordMismatchException;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) throws UserAlreadyExistsException,InvalidEmailException,InvalidPasswordException,InvalidNameException,InvalidGenderException
	{
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> checkUser(@RequestBody User user) throws InvalidEmailException,InvalidPasswordException
	{
		return new ResponseEntity<String>(userService.checkUserByEmail(user),HttpStatus.OK);
	}
 
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUser()
	{
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUser(@PathVariable("email") String email) throws InvalidEmailException
	{
		return new ResponseEntity<User>(userService.getUser(email),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId")int userId) throws IdNotFoundException
	{
		return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody UserDto userDto) throws InvalidEmailException,InvalidPasswordException,PasswordMismatchException{
		return new ResponseEntity<String>(userService.forgotUserPassword(userDto),HttpStatus.OK);
		
	}
	
	@PostMapping("/resetPassword/{userId}")
	public ResponseEntity<String> resetPassword(@PathVariable("userId") int userId,@RequestBody UserDto userDto) throws IdNotFoundException,InvalidPasswordException,PasswordMismatchException{
		return new ResponseEntity<String>(userService.resetUserPassword(userId,userDto),HttpStatus.OK);
	}
	
	@GetMapping("/user/dashboard/{userId}")
	public ResponseEntity<UserDto> userDashboard(@PathVariable("userId") int userId) throws IdNotFoundException {
		return new ResponseEntity<UserDto>(userService.getUserDashBoard(userId),HttpStatus.OK);
	}
	
	@PutMapping("/user/dashboard/{userId}")
	public ResponseEntity<User> userDashboard(@PathVariable("userId")int userId,@RequestBody UserDto userDto)throws IdNotFoundException,InvalidPasswordException,InvalidNameException,InvalidGenderException{
		return new ResponseEntity<User>(userService.updateUserById(userId,userDto),HttpStatus.OK);
	}
}
