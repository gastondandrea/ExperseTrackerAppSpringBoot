package com.henry.ExpenseTracker.entities;

import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor

public class Expense {
    private int id; //
    private double amount;
    private Date date;
    private Category category;
    private String description;

    public Expense(double amount, String description, Category category, Date date) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }
}




