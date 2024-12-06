package com.henry.ExpenseTracker.repository;

import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.exceptions.ExpenseNotFoundException;

import java.util.List;

public interface ExpenseRepository {

    List<Expense> findAll();

    Expense findById(int id);

    Expense save(Expense expense);

    int update(int id, Expense expense);

    int delete(int id);
}
