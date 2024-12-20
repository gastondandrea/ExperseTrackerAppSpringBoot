package com.henry.ExpenseTracker.controllers;

import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.exceptions.ExpenseNotFoundException;
import com.henry.ExpenseTracker.repository.Dao.Dto.request.ExpenseRequestDto;
import com.henry.ExpenseTracker.repository.Dao.Dto.response.ExpenseResponseDto;
import com.henry.ExpenseTracker.services.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        log.info("Entrando en el endpoint para obtener los Gastos");
        List<Expense> expenses = expenseService.getAllExpenses();
        log.debug("Se obtienen {} gastos", expenses.size());
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable int id) {
        log.info("Entrando al endpoint para obtener el Gasto con id: {}", id);
        try {
            Expense expense = expenseService.getExpenseById(id);
            log.debug("Gasto encontrado: {}", expense);
            return ResponseEntity.ok(expense);
        } catch (ExpenseNotFoundException e) {
            log.error("Gasto con id {} no encontrado: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        log.info("Entrando al endpoint para agregar un Gasto");
        ExpenseResponseDto expenseResponseDto = expenseService.addExpense(expenseRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable int id, @RequestBody Expense expense) {
        log.info("Entrando al endpoint para actualizar el Gasto con id: {}", id);
        try {
            Expense updatedExpense = expenseService.updateExpense(id, expense);
            log.info("Gasto con id {} actualizado exitosamente", id);
            return ResponseEntity.ok(updatedExpense);
        } catch (ExpenseNotFoundException e) {
            log.error("Fallo al actualizar el Gasto con id {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable int id) {
        log.info("Entrando al endpoint para eliminar el Gasto con id: {}", id);
        try {
            expenseService.deleteExpense(id);
            log.info("Gasto con id {} eliminado exitosamente", id);
            return ResponseEntity.ok("Gasto con id " + id + " eliminado exitosamente.");
        } catch (ExpenseNotFoundException e) {
            log.error("Fallo al eliminar el Gasto con id {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}