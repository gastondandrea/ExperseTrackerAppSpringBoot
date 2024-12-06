package com.henry.ExpenseTracker.services;
import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.repository.Dao.Dto.request.ExpenseRequestDto;
import com.henry.ExpenseTracker.repository.Dao.Dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    ExpenseResponseDto addExpense(ExpenseRequestDto expenseRequestDto);

    Expense getExpenseById(int id);

    Expense updateExpense(int id, Expense expense);

    void deleteExpense(int id);
}
