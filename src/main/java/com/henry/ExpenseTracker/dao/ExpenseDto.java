package com.henry.ExpenseTracker.dao;

import com.henry.ExpenseTracker.entities.Category;

import java.util.Date;

public class ExpenseDto {
    private int id;
    private double amount;
    private Date date;
    private Category category;
    private String description;

    // Constructor
    public ExpenseDto(double amount, String description, Category category, Date date) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    // Constructor adicional con id
    public ExpenseDto(int id, double amount, String description, Category category, Date date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) { // Nuevo setter para el ID
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense N°" + id +
                ", amount: $" + amount +
                ", date: " + date +
                ", category: " + category +
                ", description: " + description;
    }
}


