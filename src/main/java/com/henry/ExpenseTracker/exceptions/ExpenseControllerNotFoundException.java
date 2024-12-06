package com.henry.ExpenseTracker.exceptions;

public class ExpenseControllerNotFoundException extends RuntimeException {
    public ExpenseControllerNotFoundException(int id) {
        super("Expense with ID " + id + " not found.");
    }
}
