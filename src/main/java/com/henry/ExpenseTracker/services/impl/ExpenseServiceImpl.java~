package com.henry.ExpenseTracker.services.impl;

import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.repository.Dao.Dto.request.ExpenseRequestDto;
import com.henry.ExpenseTracker.repository.Dao.Dto.response.ExpenseResponseDto;
import com.henry.ExpenseTracker.repository.Dao.ExpenseRepositoryDao;
import com.henry.ExpenseTracker.services.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepositoryDao expenseRepository;

    public ExpenseServiceImpl(ExpenseRepositoryDao expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(int id) {
        Expense expense = expenseRepository.findById(id);
        return expense;
    }

    @Override
    public ExpenseResponseDto addExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = expenseRequestDtoToExpense(expenseRequestDto);
        Expense expenseFromDataBase = expenseRepository.save(expense);
        return expenseToExpenseResponse(expenseFromDataBase);
    }

    private Expense expenseRequestDtoToExpense(ExpenseRequestDto expenseRequestDto) {
        return new Expense(
                expenseRequestDto.getAmount(),
                expenseRequestDto.getDescription(),
                expenseRequestDto.getCategory(),
                expenseRequestDto.getDate());
    }

    private ExpenseResponseDto expenseToExpenseResponse(Expense expenseFromDataBase) {
        return new ExpenseResponseDto(
                expenseFromDataBase.getAmount(),
                expenseFromDataBase.getCategory(),
                expenseFromDataBase.getDescription());
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
