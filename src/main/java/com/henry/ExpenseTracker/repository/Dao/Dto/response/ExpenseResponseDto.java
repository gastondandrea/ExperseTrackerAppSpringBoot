package com.henry.ExpenseTracker.repository.Dao.Dto.response;

import com.henry.ExpenseTracker.entities.Category;

import java.nio.DoubleBuffer;
import java.util.Date;

public class ExpenseResponseDto {
    private double amount;
    private Category category;
    private String description;

    public ExpenseResponseDto(double amount, Category category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
