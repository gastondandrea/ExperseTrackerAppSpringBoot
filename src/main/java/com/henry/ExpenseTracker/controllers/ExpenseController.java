package com.henry.ExpenseTracker.controllers;

import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.exceptions.ExpenseNotFoundException;
import com.henry.ExpenseTracker.repository.Dao.Dto.request.ExpenseRequestDto;
import com.henry.ExpenseTracker.repository.Dao.Dto.response.ExpenseResponseDto;
import com.henry.ExpenseTracker.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable int id) {
        try {
            Expense expense = expenseService.getExpenseById(id);
            return ResponseEntity.ok(expense);
        } catch (ExpenseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        ExpenseResponseDto expenseResponseDto = expenseService.addExpense(expenseRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable int id, @RequestBody Expense expense) {
        try {
            Expense updatedExpense = expenseService.updateExpense(id, expense);
            return ResponseEntity.ok(updatedExpense);
        } catch (ExpenseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable int id) {
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok("Gasto con id " + id + " eliminado exitosamente.");
        } catch (ExpenseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}