package com.henry.ExpenseTracker.services;
import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.entities.User;


public interface UserService {
    double calculateTotal(User user);
    Expense findMaxExpense(User user);
}