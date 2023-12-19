package com.capg;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
import com.capg.service.UserServiceImpl;
import com.capg.util.AppConstants;
 
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
//	@Test
//	void testCreateUser_Success() throws UserAlreadyExistsException, InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidGenderException {
//		User user = new User();
//	    user.setEmail("sukku@gmail.com");
//	    user.setFirstName("sukku");	
//	    user.setLastName("db");
//	    user.setGender("female");
//	    user.setPassword("sukku@123");
//	    InvalidNameException exception = assertThrows(InvalidNameException.class, () -> userServiceImpl.registerUser(user));
//        assertEquals(AppConstants.INVALID_NAME_INFO, exception.getMsg());
//        User createdUser = userServiceImpl.registerUser(user);
//        assertNotNull(createdUser);
//   
//    }
 
    @Test
    void testCreateUser_UserAlreadyExistsException() {
        User user = new User();
        user.setEmail("sukku@gmail.com");
 
        when(userRepo.findByEmail("sukku@gmail.com")).thenReturn(user);
 
        assertThrows(UserAlreadyExistsException.class, () -> userServiceImpl.registerUser(user));
    }
 
    @Test
    void testCreateUser_InvalidNameException() {
        User user = new User();
        user.setFirstName("723sukku");
        assertThrows(InvalidNameException.class, () -> userServiceImpl.registerUser(user));
    }
 
    @Test
    void testDeleteUser_Success() throws IdNotFoundException {
        int userId = 1;
        User user = new User();
        user.setUserId(userId);
 
        when(userRepo.findByUserId(userId)).thenReturn(user);
 
        String result = userServiceImpl.deleteUser(userId);
 
        assertEquals("Id deleted Successfully", result);
        verify(userRepo, times(1)).deleteById((long) userId);
    }
 
    @Test
    void testDeleteUser_IdNotFoundException() {
        int userId = 2;
 
        when(userRepo.findByUserId(userId)).thenReturn(null);
 
        assertThrows(IdNotFoundException.class, () -> userServiceImpl.deleteUser(userId));
    }

    @Test
    void testForgotUserPassword(){
        UserDto userDto = new UserDto();
        userDto.setEmail("akila@gmail.com");	
        userDto.setPassword("Akila@123");
        userDto.setConfirmPassword("Akila@123");
        User user = new User();
        user.setEmail("akila@gmail.com");
		user.setPassword("Akila@123");
		when(userRepo.findByEmail("akila@gmail.com")).thenReturn(user);
		when(userRepo.save(any(User.class))).thenReturn(user);
		try {
		String result = userServiceImpl.forgotUserPassword(userDto);
		assertEquals("Password Reset Successful", result); 
		assertEquals("Akila@123", user.getPassword());
        }catch(InvalidEmailException e) {
        	assertEquals(AppConstants.INVALID_EMAIL_INFO,e.getMsg());
        }catch(InvalidPasswordException e) {
        	assertEquals(AppConstants.INVALID_PASSWORD_INFO,e.getMsg());
        }catch(PasswordMismatchException e) {
        	assertEquals(AppConstants.PASSWORD_MISMATCH_INFO,e.getMsg());
        }
    }
 
    @Test
    void testForgotUserPasswordWithInvalidEmail() {
        UserDto userDto = new UserDto();
        userDto.setEmail("john.doe@example.com");
        userDto.setPassword("newpassword");
        userDto.setConfirmPassword("newpassword");
        when(userRepo.findByEmail(toString())).thenReturn(null);
        assertThrows(InvalidEmailException.class, () -> userServiceImpl.forgotUserPassword(userDto));
    }
 
    @Test
    void testResetUserPassword() {
        UserDto userDto = new UserDto();
        userDto.setPassword("Alpha@1234");
        userDto.setConfirmPassword("Alpha@1234");
        User user = new User();
        user.setPassword("Akhila@1234");
 
        when(userRepo.findByUserId(anyInt())).thenReturn(user);
        when(userRepo.save(any(User.class))).thenReturn(user);
 
        try {
            String result = userServiceImpl.resetUserPassword(1, userDto);
            assertEquals("Password Reset Successfull", result);
			assertEquals("Alpha@1234", user.getPassword());
		} catch (Exception e) {
			 fail("Exception not expected: " + e.getMessage());
		}
    }
 
    @Test
    void testResetUserPasswordWithInvalidUserId() {
        UserDto userDto = new UserDto();
        userDto.setPassword("newpassword");
        userDto.setConfirmPassword("newpassword");

        when(userRepo.findByUserId(anyInt())).thenReturn(null); 
        assertThrows(IdNotFoundException.class, () -> userServiceImpl.resetUserPassword(1, userDto));
    }
//    @Test
//    void testUpdateUserById_WithValidData_ShouldUpdateUser() throws IdNotFoundException, InvalidPasswordException, InvalidNameException, InvalidGenderException {
//        // Arrange
//    	int userId = 1;
//		UserDto userDto = new UserDto("lahari", "gadi", "female");
//		User existingUser = new User(userId, "OldFirstName", "OldLastName", "Male");
//		 
//        when(userRepo.findByUserId(userId)).thenReturn(existingUser);
//        when(userRepo.save(any(User.class))).thenReturn(existingUser);
// 
//        // Act
//        User updatedUser = userServiceImpl.updateUserById(userId, userDto);
// 
//        // Assert
//        assertEquals(userDto.getFirstName(), updatedUser.getFirstName());
//        assertEquals(userDto.getLastName(), updatedUser.getLastName());
//        assertEquals(userDto.getGender(), updatedUser.getGender());
// 
//        verify(userRepo, times(1)).findByUserId(userId);
//        verify(userRepo, times(1)).save(any(User.class));
//    }
 
//    @Test
//    void testUpdateUserById_WithInvalidName_ShouldThrowInvalidNameException() {
//        // Arrange
//		int userId = 1;
//		UserDto userDto = new UserDto("lahari", "123", "female");
//		User existingUser = new User(userId, "OldFirstName", "OldLastName", "Male");
// 
//        when(userRepo.findByUserId(userId)).thenReturn(existingUser);
// 
//        // Act and Assert
//        assertThrows(InvalidNameException.class, () -> userServiceImpl.updateUserById(userId, userDto));
// 
//        verify(userRepo, times(1)).findByUserId(userId);
//        verify(userRepo, never()).save(any(User.class));
//    }
}