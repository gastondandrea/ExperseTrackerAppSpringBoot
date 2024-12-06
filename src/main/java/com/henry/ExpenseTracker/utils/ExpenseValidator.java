package com.henry.ExpenseTracker.utils;


import com.henry.ExpenseTracker.entities.Expense;

// Interface funcional para validar Gastos
@FunctionalInterface
public interface ExpenseValidator {
    boolean validate(Expense expense);
}


