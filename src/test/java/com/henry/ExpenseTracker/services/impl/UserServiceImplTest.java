package com.henry.ExpenseTracker.services.impl;


import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.entities.User;
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

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private User mockUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calculateTotal() {
        // GIVEN
        Expense expense1 = new Expense(100.0, "Groceries", null, new Date());
        Expense expense2 = new Expense(200.0, "Rent", null, new Date());
        List<Expense> expenses = Arrays.asList(expense1, expense2);

        when(mockUser.getExpenses()).thenReturn(expenses);

        // WHEN
        double total = userService.calculateTotal(mockUser);

        // THEN
        assertEquals(300.0, total);
        verify(mockUser, times(1)).getExpenses();
    }

    @Test
    void findMaxExpense() {
        // GIVEN
        Expense expense1 = new Expense(100.0, "Groceries", null, new Date());
        Expense expense2 = new Expense(300.0, "Rent", null, new Date());
        Expense expense3 = new Expense(150.0, "Utilities", null, new Date());
        List<Expense> expenses = Arrays.asList(expense1, expense2, expense3);

        when(mockUser.getExpenses()).thenReturn(expenses);

        // WHEN
        Expense maxExpense = userService.findMaxExpense(mockUser);

        // THEN
        assertEquals(expense2, maxExpense);
        verify(mockUser, times(1)).getExpenses();
    }
}