package com.henry.ExpenseTracker.services.impl;



import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.exceptions.ExpenseControllerNotFoundException;
import com.henry.ExpenseTracker.repository.ExpenseRepository;
import com.henry.ExpenseTracker.services.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(int id) {
        if(expenseRepository.findById(id) == null){
            throw new ExpenseControllerNotFoundException(id);
        }
        return expenseRepository.findById(id);
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(int id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        expense.setId(existingExpense.getId());
        expenseRepository.update(id, expense);
        return expense;
    }

    @Override
    public void deleteExpense(int id) {
        Expense existingExpense = getExpenseById(id);
        expenseRepository.delete(existingExpense.getId());
    }

}
