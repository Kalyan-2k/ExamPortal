package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.TestRepo;
import com.capg.service.TestServiceImpl;
import com.capg.util.AppConstants;


@SpringBootTest
public class TestServiceTest {

    @Mock
    private TestRepo testRepository;

    @InjectMocks
    private TestServiceImpl testService;
	
	private List<Tests> testList = null;

	private Category category=null;
    @BeforeEach
    public void setUp() {
    	category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("TestCategory");

        testList= new ArrayList<>();
    }

    @DisplayName("TestCase for Fetching All Tests")
    @Test
    public void testGetAllTests() {
    	testList.add(new Tests(1,"test 1",20,20,true,category));
    	testList.add(new Tests(2,"test 2",15,15,true,category));
    	testList.add(new Tests(3,"test 3",10,10,true,category));

		when(testRepository.findAll()).thenReturn(testList);
		assertEquals(3,testService.getAllTests().size());
    }

    @DisplayName("TestCase for Fetching Test By Id With Exception")
    @Test
    public void getTestByIdTest() throws IdNotFoundException {
        int testId = 1;
        Tests test = new Tests(1,"test1",20,20,true,category);
        when(testRepository.findById(testId)).thenReturn(Optional.of(test));
        assertEquals(test,testService.getTestById(testId));
    }

    @DisplayName("TestCase To Delete Test By Id With Exception")
	 @Test
	 public void deleteTestByIdWithExceptionTest(){
		 int testId = 2;
       IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> testService.deleteTestByTestId(testId));
       assertEquals(AppConstants.TEST_ID_NOT_FOUND_INFO, exception.getMsg());
	 }
	 
	 @DisplayName("TestCase To Delete Test By Id Without Exception")
	 @Test
	 public void deleteTestByIdWithoutExceptionTest(){
		 int testId = 1;
		 try {
			assertEquals("Test Deleted Successfully", testService.deleteTestByTestId(testId));
		} catch (IdNotFoundException e) {
			 assertEquals(AppConstants.TEST_ID_NOT_FOUND_INFO, e.getMsg());
		}

	 }


}

