package com.henry.ExpenseTracker.services.impl;

import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.entities.User;

import com.henry.ExpenseTracker.services.UserService;

import java.util.Comparator;

public class UserServiceImpl implements UserService {
    @Override
    public double calculateTotal(User user) {
        return user.getExpenses()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    @Override
    public Expense findMaxExpense(User user) {
        return user.getExpenses()
                .stream()
                .max(Comparator.comparingDouble(Expense::getAmount))
                .orElse(null);
    }

}
