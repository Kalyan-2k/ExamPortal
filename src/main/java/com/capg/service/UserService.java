package com.capg.service;
import java.util.List;

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

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User createUser(User user) throws UserAlreadyExistsException,InvalidEmailException,InvalidPasswordException,InvalidNameException,InvalidGenderException;
	
	public User getUser(String email) throws InvalidEmailException;
	
	public String deleteUser(int userId) throws IdNotFoundException;
	
	public String checkUserByEmail(User user) throws InvalidEmailException,InvalidPasswordException;
	
	public String forgotUserPassword(UserDto userDto) throws InvalidEmailException,InvalidPasswordException,PasswordMismatchException;
	
	public String resetUserPassword(int userId,UserDto userDto) throws IdNotFoundException,InvalidPasswordException,PasswordMismatchException;
	
	public UserDto getUserDashBoard(int userId) throws IdNotFoundException;
	
	public User updateUserById(int userId,UserDto userDto) throws IdNotFoundException,InvalidNameException,InvalidGenderException;
	
	public AdminDto getAdminDashboard(int adminId) throws IdNotFoundException;
	
	public User updateAdminById(int adminId,AdminDto adminDto) throws IdNotFoundException,InvalidNameException,InvalidGenderException;
}
