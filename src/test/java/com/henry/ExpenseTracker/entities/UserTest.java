package com.henry.ExpenseTracker.entities;


import com.henry.ExpenseTracker.exceptions.ExpenseUserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;



public class UserTest {

    //Propiedades
    private User user;
    private Expense expense1;
    private Expense expense2;


    //Constructor
    @BeforeEach
    void setUp(){
        user = new User("John Doe", "john.doe@example.com");
        expense1 = new Expense(50.0, "Compra semanal", new Category("Supermercado", ""), new Date());
        expense2 = new Expense(30.0, "Taxi", new Category("Transporte", ""), new Date());
    }


    @Test
    void addExpense() {
        // GIVEN
        // WHEN
        user.addExpense(expense1);

        // THEN
        assertEquals(1, user.getExpenses().size());
        assertEquals(expense1, user.getExpenses().get(0));
    }

    @Test
    void updateExpense() throws ExpenseUserNotFoundException {
        // GIVEN
        user.addExpense(expense1);
        Expense updatedExpense = new Expense(60.0, "Compra mensual", new Category("Supermercado", ""), new Date());

        // WHEN
        user.updateExpense(0, updatedExpense);

        // THEN
        assertEquals(1, user.getExpenses().size());
        assertEquals(updatedExpense, user.getExpenses().get(0));
    }

    @Test
    void removeExpense() throws ExpenseUserNotFoundException {
        // GIVEN
        user.addExpense(expense1);
        user.addExpense(expense2);
        // WHEN
        user.removeExpense(0);
        // THEN
        assertEquals(1, user.getExpenses().size());
        assertEquals(expense2, user.getExpenses().get(0));
    }
}

