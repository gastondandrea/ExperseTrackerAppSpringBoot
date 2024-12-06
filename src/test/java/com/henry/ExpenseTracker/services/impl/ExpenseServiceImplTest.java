package com.henry.ExpenseTracker.services.impl;


import com.henry.ExpenseTracker.entities.Category;
import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.repository.Dao.ExpenseRepositoryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepositoryDao expenseRepository;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests se agregan aquí
    @Test
    void getAllExpenses() {
        List<Expense> mockExpenses = Arrays.asList(
                new Expense(1, 100, "Expense 1", new Category("Food", ""), new Date()),
                new Expense(2, 200, "Expense 2", new Category("Transport", ""), new Date())
        );
        when(expenseRepository.findAll()).thenReturn(mockExpenses);

        List<Expense> expenses = expenseService.getAllExpenses();

        assertNotNull(expenses);
        assertEquals(2, expenses.size());
        verify(expenseRepository, times(1)).findAll();
    }

    @Test
    void getExpenseById() {
        Expense mockExpense = new Expense(1, 100, "Test Expense", new Category("Food", ""), new Date());
        when(expenseRepository.findById(1)).thenReturn(mockExpense);

        Expense expense = expenseService.getExpenseById(1);

        assertNotNull(expense);
        assertEquals(1, expense.getId());
        assertEquals("Test Expense", expense.getDescription());
        verify(expenseRepository, times(1)).findById(1);
    }
    @Test
    void updateExpense() {
        Expense existingExpense = new Expense(1, 100, "Old Description", new Category("Food", ""), new Date());
        Expense updatedExpense = new Expense(1, 200, "Updated Description", new Category("Food", ""), new Date());

        when(expenseRepository.findById(1)).thenReturn(existingExpense);
        when(expenseRepository.update(eq(1), any(Expense.class))).thenReturn(1);

        Expense result = expenseService.updateExpense(1, updatedExpense);

        assertNotNull(result);
        assertEquals(200, result.getAmount());
        assertEquals("Updated Description", result.getDescription());
        verify(expenseRepository, times(1)).findById(1);
        verify(expenseRepository, times(1)).update(eq(1), any(Expense.class));
    }

    @Test
    void deleteExpense() {
        when(expenseRepository.findById(1)).thenThrow(new RuntimeException("Expense not found"));

        Exception exception = assertThrows(RuntimeException.class, () -> expenseService.deleteExpense(1));

        assertEquals("Expense not found", exception.getMessage());
        verify(expenseRepository, times(1)).findById(1);
        verify(expenseRepository, never()).delete(anyInt());
    }
}

