package com.henry.ExpenseTracker.dao.impl;

import com.henry.ExpenseTracker.dao.ExpenseDao;
import com.henry.ExpenseTracker.dao.ExpenseDto;
import com.henry.ExpenseTracker.entities.Category;
import com.henry.ExpenseTracker.entities.Expense;
/*import config.DatabaseConnection;*/


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImplH2 implements ExpenseDao {
    /*private final Connection connection;

    public ExpenseDaoImplH2() {
        this.connection = DatabaseConnection.getDBConnection();
    }*/

    @Override
    public void addExpense(ExpenseDto expenseDto) {
        /*try{

            Expense newExpense = new Expense();
            newExpense.setAmount(expenseDto.getAmount());
            newExpense.setDescription(expenseDto.getDescription());
            newExpense.setCategory(expenseDto.getCategory());
            newExpense.setDate(expenseDto.getDate());

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO expenses (amount, description, category, date) VALUES (?, ?, ?, ?)");
            ps.setDouble(1, newExpense.getAmount());
            ps.setString(2, newExpense.getDescription());
            ps.setString(3, newExpense.getCategory().getName());
            ps.setTimestamp(4, new Timestamp(newExpense.getDate().getTime()));
            ps.executeUpdate();
            System.out.println("Gasto agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public List<Expense> getAllExpenses() {
        /*List<Expense> expenses = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM expenses");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                String categoryName = rs.getString("category");
                Date date = new Date(rs.getTimestamp("date").getTime());

                Category category = new Category(categoryName, "");
                Expense expense = new Expense(amount, description, category, date);
                expense.setId(id);
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;*/
        List<Expense> expenses = new ArrayList<>();
        return expenses;
    }

    @Override
    public void updateExpense(ExpenseDto expenseDto) {
        /*try{

            Expense newExpense = new Expense();
            newExpense.setId(expenseDto.getId());
            newExpense.setAmount(expenseDto.getAmount());
            newExpense.setDescription(expenseDto.getDescription());
            newExpense.setCategory(expenseDto.getCategory());
            newExpense.setDate(expenseDto.getDate());

            PreparedStatement ps = connection.prepareStatement("UPDATE expenses SET amount = ?, description = ?, category = ?, date = ? WHERE id = ?");
            ps.setDouble(1, newExpense.getAmount());
            ps.setString(2, newExpense.getDescription());
            ps.setString(3, newExpense.getCategory().getName());
            ps.setTimestamp(4, new Timestamp(newExpense.getDate().getTime()));
            ps.setInt(5, newExpense.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Gasto actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el gasto con ID: " + newExpense.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void deleteExpense(int expenseId) {
        /*try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM expenses WHERE id = ?");
            ps.setInt(1, expenseId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Gasto eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el gasto con ID: " + expenseId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
