package com.henry.ExpenseTracker.dao;
import com.henry.ExpenseTracker.entities.Expense;
import java.util.List;

public interface ExpenseDao {
    // CREATE
    void addExpense(ExpenseDto expenseDto);

    //READ
    List<Expense> getAllExpenses();

    // UPDATE
    void updateExpense(ExpenseDto expenseDto);

    // DELETE
    void deleteExpense(int expenseId);

}
