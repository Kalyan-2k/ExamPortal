package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.User;
import com.capg.repo.UserRepo;
import com.capg.service.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepo userRepo;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	
	@Test 
	public void getAllUserTest()   //Method to check if getAllUsers method is working properly or not
	{
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1,"pass123", "sachin", "kumar","sachin@gmail.com" ,"user","male" ));
		users.add(new User(2,"pass123", "mahesh", "kumar","sachin@gmail.com" ,"user","male" ));
		users.add(new User(3,"pass123", "sachin", "rahul","sachin@gmail.com" ,"user","male" ));
		
		when(userRepo.findAll()).thenReturn(users);
		
		assertEquals(3, userServiceImpl.getAllUsers().size());
		
	}
	
	
}
