package com.henry.ExpenseTracker.services;
import com.henry.ExpenseTracker.entities.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense addExpense(Expense expense);

    Expense getExpenseById(int id);

    Expense updateExpense(int id, Expense expense);

    void deleteExpense(int id);
}
