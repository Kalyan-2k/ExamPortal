package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.User;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidEmailException;
import com.capg.exceptions.InvalidGenderException;
import com.capg.exceptions.InvalidNameException;
import com.capg.exceptions.InvalidPasswordException;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.repo.UserRepo;
import com.capg.util.AppConstants;
import java.util.regex.*;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) throws UserAlreadyExistsException,InvalidEmailException,InvalidPasswordException,InvalidNameException,InvalidGenderException
	{
		User local=this.userRepo.findByEmail(user.getEmail());
		
		if(local!=null)
		{
			throw new UserAlreadyExistsException("User already present");
		}
		else {
			if( !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) 
			{
				throw new InvalidEmailException(AppConstants.INVALID_EMAIL_INFO);
			}
			if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) 
			{
				throw new InvalidPasswordException(AppConstants.INVALID_PASSWORD_INFO);
			}
			
			if(!user.getFirstName().matches("^[a-zA-Z ]*$") && !user.getLastName().matches("^[a-zA-Z ]*$"))
			{
				
				throw new InvalidNameException(AppConstants.INVALID_NAME_INFO);
				
			}
			
			if(!user.getGender().toLowerCase().equals("male") && !user.getGender().toLowerCase().equals("female") &&!user.getGender().toLowerCase().equals("others"))
			{
				throw new InvalidGenderException(AppConstants.INVALID_GENDER_INFO);
			}
			
				
			}
		return userRepo.save(user);
		
	}
	
	public User getUser(String s)throws InvalidEmailException
	{
		User user=this.userRepo.findByEmail(s);
	
		if(user==null)
		{
			System.out.println("Exception being thrown");
			throw new InvalidEmailException(AppConstants.USER_INVALID_EMAIL_INFO);
		}
		return user;
	
	}
	
	public String deleteUser(int userId)throws IdNotFoundException
	{
		User user= userRepo.findById(userId);
		if(user == null)
		{
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
		else {
			userRepo.deleteById((long) userId);
		}
		return "Id deleted Successfully";
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	public String checkUserByEmail(User user) throws InvalidEmailException,InvalidPasswordException{
		User check_user = userRepo.findByEmail(user.getEmail().toLowerCase());
		if(check_user !=null) {
			if(check_user.getPassword().equals(user.getPassword())) {
				if (check_user.getRole().equals("user"))
					return "Welcome to User Dashboard";
				else
					return "Welcome to Admin Dashboard";
			}else {
				throw new InvalidPasswordException(AppConstants.USERNAME_OR_PASSWORD_MISMATCH);
			}
		}
		throw new InvalidEmailException(AppConstants.USERNAME_OR_PASSWORD_MISMATCH);
	}
}
