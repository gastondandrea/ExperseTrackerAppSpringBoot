package com.henry.ExpenseTracker.repository.Dao;

import com.henry.ExpenseTracker.entities.Expense;

import java.util.List;

public interface ExpenseRepositoryDao {

    List<Expense> findAll();

    Expense findById(int id);

    Expense save(Expense expense);

    int update(int id, Expense expense);

    int delete(int id);
}
