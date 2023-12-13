package com.capg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.Category;
import com.capg.entity.QuestionBank;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.QuestionBankRepo;
import com.capg.service.QuestionBankServiceImpl;
import com.capg.util.AppConstants;

@SpringBootTest
public class QuestionBankServiceTest{

    @Mock
    private QuestionBankRepo questionBankRepo;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private QuestionBankServiceImpl questionBankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddQuestionBank() {
        QuestionBank questionBank = new QuestionBank();
        Category category = new Category();
        questionBank.setCategory(category);

        when(categoryRepository.existsById(anyInt())).thenReturn(true);
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(category));
        when(questionBankRepo.save(any(QuestionBank.class))).thenReturn(questionBank);

        QuestionBank result = questionBankService.addQuestionBank(questionBank);

        assertNotNull(result);
        assertEquals(category, result.getCategory());
    }

    @Test
    void testUpdateQuestionBankById() throws IdNotFoundException {
        int questionBankId = 1;
        QuestionBank existingQuestionBank = new QuestionBank();
        existingQuestionBank.setQuestionBankId(questionBankId);

        when(questionBankRepo.existsById(questionBankId)).thenReturn(true);
        when(questionBankRepo.findById(questionBankId)).thenReturn(Optional.of(existingQuestionBank));
        when(questionBankRepo.save(any(QuestionBank.class))).thenReturn(existingQuestionBank);

        QuestionBank updatedQuestionBank = new QuestionBank();
        updatedQuestionBank.setQuestionBankId(questionBankId);

        QuestionBank result = questionBankService.updateQuestionBankById(questionBankId, updatedQuestionBank);

        assertNotNull(result);
        assertEquals(questionBankId, result.getQuestionBankId());
    }

    @Test
    void testUpdateQuestionBankByIdNotFound() {
        int questionBankId = 1;

        when(questionBankRepo.existsById(questionBankId)).thenReturn(false);

        assertThrows(IdNotFoundException.class,
                () -> questionBankService.updateQuestionBankById(questionBankId, new QuestionBank()));
    }

    @Test
    void testGetAllQuestionBanks() {
        List<QuestionBank> questionBanks = new ArrayList<>();
        when(questionBankRepo.findAll()).thenReturn(questionBanks);

        List<QuestionBank> result = questionBankService.getAllQuestionBanks();

        assertNotNull(result);
        assertEquals(questionBanks, result);
    }

    @Test
    void testDeleteQuestionBankById() throws IdNotFoundException {
        int questionBankId = 1;

        when(questionBankRepo.existsById(questionBankId)).thenReturn(true);

        String result = questionBankService.deleteQuestionBankById(questionBankId);

        assertNotNull(result);
        assertEquals("Id deleted successfully", result);
    }

    @Test
    void testDeleteQuestionBankByIdNotFound() {
        int questionBankId = 1;

        when(questionBankRepo.existsById(questionBankId)).thenReturn(false);

        assertThrows(IdNotFoundException.class, () -> questionBankService.deleteQuestionBankById(questionBankId));
    }
}

