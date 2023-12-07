package com.capg.service;
import java.util.List;

import com.capg.entity.User;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidEmailException;
import com.capg.exceptions.InvalidGenderException;
import com.capg.exceptions.InvalidNameException;
import com.capg.exceptions.InvalidPasswordException;
import com.capg.exceptions.UserAlreadyExistsException;

public interface UserService {
	
	public List<User> getAllUsers();
	public User createUser(User user) throws UserAlreadyExistsException,InvalidEmailException,InvalidPasswordException,InvalidNameException,InvalidGenderException;
	public User getUser(String email) throws InvalidEmailException;
	public String deleteUser(int userId) throws IdNotFoundException;
	public String checkUserByEmail(User user) throws InvalidEmailException,InvalidPasswordException;
	
}
