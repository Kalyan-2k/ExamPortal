package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
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
import com.capg.exceptions.CategoryAlreadyExistsException;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionBankRepo;
import com.capg.repo.QuestionRepository;
import com.capg.service.CategoryServiceImpl;
import com.capg.util.AppConstants;

@SpringBootTest
public class CategoryServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	
	@Mock
	private QuestionRepository questionRepository;
	
	@Mock 
	private QuestionBankRepo questionBankRepository;
	
	@InjectMocks
	private CategoryServiceImpl categoryService;
	
	private List<Question> questionsList = null;
	
	private List<Tests> testsList = null;

	@BeforeEach
	public void setUp() {
		questionsList = new ArrayList<>();
		questionsList.add(new Question(1,"test Question 1","abc","bcd","xyz","pqr","bcd",true));
		questionsList.add(new Question(2,"test Question 2","abc","bcd","xyz","pqr","xyz",true));
		questionsList.add(new Question(3,"test Question 3","abc","bcd","xyz","pqr","abc",true));
		questionsList.add(new Question(4,"test Question 4","abc","bcd","xyz","pqr","pqr",true));
		
		testsList= new ArrayList<>();
		testsList.add(new Tests(1,"test 1",20,20,true));
		testsList.add(new Tests(2,"test 2",15,15,true));
		testsList.add(new Tests(3,"test 3",10,10,true));
	}
	
	@DisplayName("Test to add a new Category without exception ")
	@Test
    public void createCategoryTest() throws CategoryAlreadyExistsException {
        // Arrange
        Category categoryToAdd = new Category(1,"python",new QuestionBank(1,"Python Question Bank"),questionsList,testsList);
        when(categoryRepository.findByCategoryName("python")).thenReturn(null);
        when(categoryRepository.save(any(Category.class))).thenReturn(categoryToAdd);

        // Act
        Category addedCategory = categoryService.createCategory(categoryToAdd);

        // Assert
        assertNotNull(addedCategory);
        assertEquals("python", addedCategory.getCategoryName());
        verify(categoryRepository, times(1)).findByCategoryName("python");
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    public void createCategoryWithExistingCategoryTest() {
        // Arrange
        Category categoryToAdd = new Category(1,"python",new QuestionBank(1,"Python Question Bank"),questionsList,testsList);
        when(categoryRepository.findByCategoryName("python")).thenReturn(categoryToAdd);

        // Act and Assert
        assertThrows(CategoryAlreadyExistsException.class, () -> categoryService.createCategory(categoryToAdd));
        verify(categoryRepository, times(1)).findByCategoryName("python");
        verify(categoryRepository, times(0)).save(any(Category.class));
    }
    
	@DisplayName("TestCase To Fetch All Categories")
	@Test
	public void getAllCategoriesTest() {
		List<Category> categoryList = new ArrayList<>();
		
		categoryList.add(new Category(1,"python",new QuestionBank(1,"Python Question Bank"),questionsList,testsList));
		categoryList.add(new Category(2,"Java",new QuestionBank(2,"Java Question Bank"),questionsList,testsList));
		categoryList.add(new Category(3,"C++",new QuestionBank(3,"C++ Question Bank"),questionsList,testsList));
		
		when(categoryRepository.findAll()).thenReturn(categoryList);
		assertEquals(3,categoryService.fetchCategory().size());
	}
	
	 @DisplayName("TestCase To Fetch Category By Id With Exception")
	 @Test
	 public void getCategoryByIdWithExceptionTest(){
		 int categoryId = 2;
//		 when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> categoryService.fetchCategoryById(categoryId));
        assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 
	 @DisplayName("TestCase To Fetch Category By Id Without Exception")
	 @Test
	 public void getCategoryByIdWithoutExceptionTest(){
		 int categoryId = 1;
		 Category category = new Category(1,"python",new QuestionBank(1,"Python Question Bank"),questionsList,testsList);
		 try {
		 when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
		 assertEquals(category,categoryService.fetchCategoryById(categoryId));
		 }catch(IdNotFoundException e) {
			 assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO, e.getMsg());
		 }
	 }
	 
	 @DisplayName("TestCase To Delete Category By Id With Exception")
	 @Test
	 public void deleteCategoryByIdWithExceptionTest(){
		 int categoryId = 2;
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> categoryService.deleteCategoryById(categoryId));
        assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 
	 @DisplayName("TestCase To Delete Category By Id Without Exception")
	 @Test
	 public void deleteCategoryByIdWithoutExceptionTest(){
		 int categoryId = 1;
		 try {
			assertEquals("Category Deleted Successfully",categoryService.deleteCategoryById(categoryId));
		} catch (IdNotFoundException e) {
			 assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO, e.getMsg());
		}

	 }
	 
	 @DisplayName("TestCase To Update Category By Id With Exception")
	 @Test
	 public void updateCategoryByIdWithExceptionTest(){
		 int categoryId = 2;
		 Category category = new Category(1,"Java",new QuestionBank(1,"Java Question Bank"),questionsList,testsList);
         IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> categoryService.updateCategoryById(categoryId,category));
        assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO, exception.getMsg());

	 }
	 
//	 @DisplayName("TestCase To Update Category By Id Without Exception")
//	 @Test
//	 public void updateCategoryByIdWithoutExceptionTest() {
//	     // Assuming you have a valid category and category ID
//	     int categoryId = 1;
////	     Category category = new Category(1,"python",new QuestionBank(1,"Python Question Bank"),questionsList,testsList);
//	     Category updatedCategory = new Category(1, "Updated Category", new QuestionBank(1, "Updated Question Bank"), questionsList, testsList);
//
//	     try {
//	         when(categoryRepository.existsById(categoryId)).thenReturn(true);
//	         when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty()); // Replace with an actual existing category
//	         when(categoryRepository.save(any(Category.class))).thenReturn(updatedCategory);
//
//	         Category result = categoryService.updateCategoryById(categoryId, updatedCategory);
//
//	         assertEquals(updatedCategory, result);
//	         verify(categoryRepository, times(1)).save(any(Category.class));
//	         verify(categoryRepository, times(1)).existsById(categoryId);
//	         verify(categoryRepository, times(1)).findById(categoryId);
//	     } catch (IdNotFoundException e) {
//	         assertEquals(AppConstants.CATEGORY_ID_NOT_FOUND_INFO,e.getMessage());
//	     }
//	 }
}
