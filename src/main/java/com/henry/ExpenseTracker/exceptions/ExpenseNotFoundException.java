package com.henry.ExpenseTracker.exceptions;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
