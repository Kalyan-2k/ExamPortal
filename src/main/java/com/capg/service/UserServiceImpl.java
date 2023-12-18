package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.AdminDto;
import com.capg.dto.UserDto;
import com.capg.entity.User;
import com.capg.exceptions.IdNotFoundException;
import com.capg.exceptions.InvalidEmailException;
import com.capg.exceptions.InvalidGenderException;
import com.capg.exceptions.InvalidNameException;
import com.capg.exceptions.InvalidPasswordException;
import com.capg.exceptions.PasswordMismatchException;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.repo.UserRepo;
import com.capg.util.AppConstants;

@Service
public class UserServiceImpl implements UserService 
{
	/*
	 * 
	 * @Description : This method is used to add a product 
	 * @Param : It takes product as a parameter
	 * @returns  : It returns the prodouct
	 * @throws :Tells the developer what exceptions might arise in the code 
	 * @createdDate : 7-12-2023
	 * @author : kalyan
	 */ 
	
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
			if(!user.getFirstName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)+$") || !user.getLastName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$"))
			{
				throw new InvalidNameException(AppConstants.INVALID_NAME_INFO);
			}		
			if(!user.getGender().toLowerCase().equals("male") && !user.getGender().toLowerCase().equals("female") && !user.getGender().toLowerCase().equals("others"))
			{
				throw new InvalidGenderException(AppConstants.INVALID_GENDER_INFO);
			}	
			if( !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) 
			{
				throw new InvalidEmailException(AppConstants.INVALID_EMAIL_INFO);
			}
			if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) 
			{
				throw new InvalidPasswordException(AppConstants.INVALID_PASSWORD_INFO);
			}
		}
		return userRepo.save(user);
		
	}
	
	public User getUser(String email)throws InvalidEmailException
	{
		User user=this.userRepo.findByEmail(email);
	
		if(user==null)
		{
			System.out.println("Exception being thrown");
			throw new InvalidEmailException(AppConstants.USER_INVALID_EMAIL_INFO);
		}
		return user;
	
	}
	
	public String deleteUser(int userId)throws IdNotFoundException
	{
		User user= userRepo.findByUserId(userId);
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
		
		List<User> users = userRepo.findAll();
		System.out.println(users);
		
		return users;
	}
	
	public String checkUserByEmail(User user) throws InvalidEmailException,InvalidPasswordException{
		User check_user = userRepo.findByEmail(user.getEmail().toLowerCase());
		if(check_user !=null) {
			if(check_user.getPassword().equals(user.getPassword())) {
				if (check_user.getRole().equals("user"))
					return "Welcome User";
				else
					return "Welcome Admin";
			}else {
				throw new InvalidPasswordException(AppConstants.USERNAME_OR_PASSWORD_MISMATCH);
			}
		}
		throw new InvalidEmailException(AppConstants.USERNAME_OR_PASSWORD_MISMATCH);
	}
	
	public String forgotUserPassword(UserDto userDto) throws InvalidEmailException,InvalidPasswordException,PasswordMismatchException{
		User user = userRepo.findByEmail(userDto.getEmail());
		if(user == null) {
			throw new InvalidEmailException(AppConstants.USER_INVALID_EMAIL_INFO);
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
			throw new InvalidPasswordException(AppConstants.INVALID_PASSWORD_INFO);
		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
			throw new PasswordMismatchException(AppConstants.PASSWORD_MISMATCH_INFO);
		else{
			user.setPassword(userDto.getPassword());
			userRepo.save(user);
			return "Password Reset Successful";
		}
	}
	
	public String resetUserPassword(int userId,UserDto userDto) throws IdNotFoundException,InvalidPasswordException,PasswordMismatchException{
		User user = userRepo.findByUserId(userId);
		if (user == null) {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
			throw new InvalidPasswordException(AppConstants.INVALID_PASSWORD_INFO);
		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
			throw new PasswordMismatchException(AppConstants.PASSWORD_MISMATCH_INFO);
		else {
			user.setPassword(userDto.getPassword());
			userRepo.save(user);
			return "Password Reset Successfull";	
		}
	}
	
	public UserDto getUserDashBoard(int userId) throws IdNotFoundException{
		if(userRepo.existsById((long)userId)) {
			User user = userRepo.findByUserId(userId);
			if(user.getRole().equals("user")) {
				UserDto newUser = new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getGender(),user.getEmail());
				return newUser;
			}else {
				throw new IdNotFoundException(AppConstants.INVALID_USER_INFO);
			}
		}
		else {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
	}
	public User updateUserById(int userId,UserDto userDto) throws IdNotFoundException,InvalidNameException,InvalidGenderException
	{
		User updateUser=this.userRepo.findByUserId(userId);
		if(updateUser==null) {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
		else {
			if(!userDto.getFirstName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)+$") || !userDto.getLastName().matches("^[a-zA-Z ]*$"))
			{
				throw new InvalidNameException(AppConstants.INVALID_NAME_INFO);
			}else {
				updateUser.setFirstName(userDto.getFirstName());
				updateUser.setLastName(userDto.getLastName());
			}
			if(!userDto.getGender().toLowerCase().equals("male") && !userDto.getGender().toLowerCase().equals("female") &&!userDto.getGender().toLowerCase().equals("others"))
			{
				throw new InvalidGenderException(AppConstants.INVALID_GENDER_INFO);
			}else {
				updateUser.setGender(userDto.getGender());
			}
			return userRepo.save(updateUser);
		}				
	}
	
	public AdminDto getAdminDashboard(int adminId) throws IdNotFoundException{
		if(userRepo.existsById((long)adminId)){
			User user = userRepo.findByUserId(adminId);
			if(user.getRole().equals("admin")) {
				AdminDto adminDto = new AdminDto(adminId,user);
				return adminDto;
			}else {
				throw new IdNotFoundException(AppConstants.INVALID_USER_INFO);
			}
			
		}else {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
	}
	
	public User updateAdminById(int adminId,AdminDto adminDto) throws IdNotFoundException,InvalidNameException,InvalidGenderException{
		User updateUser=this.userRepo.findByUserId(adminId);
		if(updateUser==null) {
			throw new IdNotFoundException(AppConstants.USER_ID_NOT_FOUND_INFO);
		}
		else {
			if(!adminDto.getFirstName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)+$") || !adminDto.getLastName().matches("^[a-zA-Z ]*$"))
			{
				throw new InvalidNameException(AppConstants.INVALID_NAME_INFO);
			}else {
				updateUser.setFirstName(adminDto.getFirstName());
				updateUser.setLastName(adminDto.getLastName());
			}
			if(!adminDto.getGender().toLowerCase().equals("male") && !adminDto.getGender().toLowerCase().equals("female") &&!adminDto.getGender().toLowerCase().equals("others"))
			{
				throw new InvalidGenderException(AppConstants.INVALID_GENDER_INFO);
			}else {
				updateUser.setGender(adminDto.getGender());
			}
			return userRepo.save(updateUser);
		}				
	}
}
