package com.capg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.Category;
import com.capg.entity.Question;
import com.capg.entity.QuestionBank;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionBankRepo;
import com.capg.service.QuestionBankServiceImpl;
import com.capg.util.AppConstants;

@SpringBootTest
public class QuestionBankServiceTest{

    @Mock
    private QuestionBankRepo questionBankRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private QuestionBankServiceImpl questionBankService;

    private Category category;
    private List<QuestionBank> questionBank = null;

    @BeforeEach
    public void setUp() {
        category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Sample Category");
       
        questionBank= new ArrayList<>();
    }
    @Test
    void testUpdateQuestionBankById() throws IdNotFoundException {
        int questionBankId = 1; 
        QuestionBank existingQuestionBank = new QuestionBank();
        existingQuestionBank.setQuestionBankId(questionBankId);

        when(questionBankRepository.existsById(questionBankId)).thenReturn(true);
        when(questionBankRepository.findById(questionBankId)).thenReturn(Optional.of(existingQuestionBank));
        when(questionBankRepository.save(any(QuestionBank.class))).thenReturn(existingQuestionBank);

        QuestionBank updatedQuestionBank = new QuestionBank();
        updatedQuestionBank.setQuestionBankId(questionBankId);

        QuestionBank result = questionBankService.updateQuestionBankById(questionBankId, updatedQuestionBank);

        assertNotNull(result);
        assertEquals(questionBankId, result.getQuestionBankId());
       }
        
    @DisplayName("TestCase for update Test By Id Without Exception")
    @Test
    void testUpdateQuestionBankByIdNotFound() {
        int questionBankId = 1;
        questionBank.add(new QuestionBank(1,"python questionBank",category));
        
        when(questionBankRepository.existsById(questionBankId)).thenReturn(false);

        assertThrows(IdNotFoundException.class,
                () -> questionBankService.updateQuestionBankById(questionBankId, new QuestionBank()));
    }

    @Test
    void testGetAllQuestionBanks() {
    	
    	questionBank.add(new QuestionBank(1,"python questionBank",category));
        questionBank.add(new QuestionBank(2,"java questionBank",category));
        questionBank.add(new QuestionBank(3,"c questionBank",category));
        
        when(questionBankRepository.findAll()).thenReturn(questionBank);
		assertEquals(3,questionBankService.getAllQuestionBanks().size());
    }       
    

    @Test
    void testDeleteQuestionBankById() throws IdNotFoundException {
        int questionBankId = 1;

        when(questionBankRepository.existsById(questionBankId)).thenReturn(true);

        String result = questionBankService.deleteQuestionBankById(questionBankId);

        assertNotNull(result);
        assertEquals("Id deleted successfully", result);
    }

    @Test
    void testDeleteQuestionBankByIdNotFound() {
        int questionBankId = 1;

        when(questionBankRepository.existsById(questionBankId)).thenReturn(false);

        assertThrows(IdNotFoundException.class, () -> questionBankService.deleteQuestionBankById(questionBankId));
    }
    
}

