package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.capg.entity.Question;
import com.capg.entity.QuestionBank;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionRepository;
import com.capg.service.QuestionServiceImpl;
import com.capg.util.AppConstants;

@SpringBootTest
public class QuestionServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	
	@Mock
	private QuestionRepository questionRepository;
		
	@InjectMocks
	private QuestionServiceImpl questionService;
	
	private List<Question> questionsList = null;
	
	Category category=null;
	
	private List<Tests> testsList = null;

	@BeforeEach
	public void setUp() {
		Category category = new Category(1,"python",new QuestionBank(1,"Python Question Bank"),null,null);
	}
	
	
	@DisplayName("Test Case: Add Question Without Exception")
    @Test
    public void testCreateQuestionWithoutException() {
        // Arrange
        Question questionToAdd = new Question(1,"test Question 1","abc","bcd","xyz","pqr","bcd",category,true);
        Category category = new Category(1,"python",null,null,null);
        questionToAdd.setCategory(category);

        when(categoryRepository.existsById(anyInt())).thenReturn(true);
        when(categoryRepository.findById(anyInt())).thenReturn(java.util.Optional.of(category));
        when(questionRepository.save(any(Question.class))).thenReturn(questionToAdd);

        // Act
        Question addedQuestion = questionService.createQuestion(questionToAdd);

        // Assert
        assertNotNull(addedQuestion);
        verify(categoryRepository, times(1)).existsById(anyInt());
        verify(categoryRepository, times(1)).findById(anyInt());
        verify(questionRepository, times(1)).save(any(Question.class));
    }

//    @DisplayName("Test Case: Add Question With Exception (Category Not Found)")
//    @Test
//    public void testCreateQuestionWithException() {
//        // Arrange
//    	Category category_new = new Category(2,"Java",null,null,null);
//    	Question questionToAdd = new Question(1,"test Question 1","abc","bcd","xyz","pqr","bcd",category_new,true);
////        categoryRepository.save(category);
//        questionToAdd.setCategory(category);
//
//        when(categoryRepository.existsById(anyInt())).thenReturn(false);
//        questionRepository.save(questionToAdd);
//        // Act and Assert
//        assertThrows(IdNotFoundException.class, () -> questionService.createQuestion(questionToAdd));
//        verify(categoryRepository, times(1)).existsById(anyInt());
//        verify(categoryRepository, times(0)).findById(anyInt());
//        verify(questionRepository, times(0)).save(any(Question.class));
//    }
    
    @DisplayName("TestCase To Fetch All Questions")
	@Test
	public void getAllQuestionsTest() {
		
		questionsList = new ArrayList<>();
		questionsList.add(new Question(1,"test Question 1","abc","bcd","xyz","pqr","bcd",category,true));
		questionsList.add(new Question(2,"test Question 2","abc","bcd","xyz","pqr","xyz",category,true));
		questionsList.add(new Question(3,"test Question 3","abc","bcd","xyz","pqr","abc",category,true));
		questionsList.add(new Question(4,"test Question 4","abc","bcd","xyz","pqr","pqr",category,true));
//		category.setQuestions(questionsList);
		
		when(questionRepository.findAll()).thenReturn(questionsList);
		assertEquals(4,questionService.fetchQuestions().size());
	}
	
	 @DisplayName("TestCase To Fetch Questions By Id With Exception")
	 @Test
	 public void getQuestionsByIdWithExceptionTest(){
		 int questionId = 2;
//		 when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> questionService.fetchQuestionById(questionId));
        assertEquals(AppConstants.QUESTION_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 
//	 @DisplayName("TestCase To Fetch Question By Id Without Exception")
//	 @Test
//	 public void getQuestionByIdWithoutExceptionTest() throws IdNotFoundException {
//	     // Arrange
//	     int questionId = 1;
//	     Question question = new Question(1, "test Question 1", "abc", "bcd", "xyz", "pqr", "bcd", category, true);
//
//	     when(questionRepository.findById(questionId)).thenReturn(Optional.of(question));
//
//	     // Act
//	     Question result = questionService.fetchQuestionById(questionId);
//
//	     // Assert
//	     assertEquals(question, result);
//	     verify(questionRepository, times(1)).findById(questionId);
//	 }
	 
	 @DisplayName("TestCase To Delete Question By Id With Exception")
	 @Test
	 public void deleteQuestionByIdWithExceptionTest(){
		 int questionId = 2;
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> questionService.deleteQuestionById(questionId));
        assertEquals(AppConstants.QUESTION_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 
	 @DisplayName("TestCase To Delete Question By Id Without Exception")
	 @Test
	 public void deleteQuestionByIdWithoutExceptionTest(){
		 int questionId = 1;
		 try {
			assertEquals("Category Deleted Successfully",questionService.deleteQuestionById(questionId));
		} catch (IdNotFoundException e) {
			 assertEquals(AppConstants.QUESTION_ID_NOT_FOUND_INFO, e.getMsg());
		}

	 }
	 
	 @DisplayName("TestCase To Update Question By Id With Exception")
	 @Test
	 public void updateQuestionByIdWithExceptionTest(){
		 int questionId = 2;
		 Question question = new Question(1,"test Question 1","bbc","bcd","xyz","pqr","pqr",category,true);
         IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> questionService.updateQuestionById(questionId,question));
        assertEquals(AppConstants.QUESTION_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 @DisplayName("Test Case: Update Question By Id Without Exception")
	 @Test
	 public void testUpdateQuestionByIdWithoutException() throws IdNotFoundException {
	        // Arrange
	        int questionId = 1;
	        Question existingQuestion = new Question(1, "test Question 1", "bbc", "bcd", "xyz", "pqr", "pqr", category, true);
	        Question updatedQuestion = new Question(1, "Updated Question", "bbc", "bcd", "xyz", "pqr", "pqr", category, true);

	        when(questionRepository.existsById(questionId)).thenReturn(true);
	        when(questionRepository.findById(questionId)).thenReturn(java.util.Optional.of(existingQuestion));
	        when(questionRepository.save(any(Question.class))).thenReturn(updatedQuestion);

	        // Act
	        Question result = questionService.updateQuestionById(questionId, updatedQuestion);

	        // Assert
	        assertNotNull(result);
	        assertEquals("Updated Question", result.getQuestionName());
	        verify(questionRepository, times(1)).existsById(questionId);
	        verify(questionRepository, times(1)).findById(questionId);
	        verify(questionRepository, times(1)).save(any(Question.class));
	    }
}

