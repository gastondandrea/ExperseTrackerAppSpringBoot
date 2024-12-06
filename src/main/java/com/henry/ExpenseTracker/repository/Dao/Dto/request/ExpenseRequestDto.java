package com.henry.ExpenseTracker.repository.Dao.Dto.request;

import com.henry.ExpenseTracker.entities.Category;

import java.util.Date;

public class ExpenseRequestDto {
    private double amount;
    private Date date;
    private Category category;
    private String description;

    public ExpenseRequestDto(double amount, Date date, Category category, String description) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
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
}
