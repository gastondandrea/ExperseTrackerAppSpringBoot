package com.henry.ExpenseTracker.repository.Impl;

import com.henry.ExpenseTracker.entities.Category;
import com.henry.ExpenseTracker.entities.Expense;
import com.henry.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final static String SELECT_ALL_EXPENSES = "SELECT * FROM expenses";
    private final static String FIND_EXPENSE_BY_ID = "SELECT * FROM expenses WHERE id = ?";
    private final static String INSERT_EXPENSE = "INSERT INTO expenses (amount, category, description, date) VALUES (?, ?, ?, ?)";
    private final static String UPDATE_EXPENSE = "UPDATE expenses SET amount = ?, category = ?, description = ?, date = ? WHERE id = ?";
    private final static String DELETE_EXPENSE = "DELETE FROM expenses WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Expense> rowMapper = new RowMapper<Expense>() {
        @Override
        public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
            Expense expense = new Expense();
            expense.setId(rs.getInt("id"));
            expense.setAmount(rs.getInt("amount"));
            String categoryName = rs.getString("category");
            Category category = new Category(categoryName, "");
            expense.setCategory(category);
            expense.setDescription(rs.getString("description"));
            expense.setDate(rs.getDate("date"));
            return expense;
        }
    };

    @Override
    public List<Expense> findAll() {
        return jdbcTemplate.query(SELECT_ALL_EXPENSES, rowMapper);
    }

    @Override
    public Expense findById(int id) {
        return jdbcTemplate.queryForObject(FIND_EXPENSE_BY_ID, new Object[]{id}, rowMapper);
    }

    @Override
    public Expense save(Expense expense) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_EXPENSE, new String[]{"id"});
            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getCategory().getName());
            ps.setString(3, expense.getDescription());
            ps.setDate(4, new java.sql.Date(expense.getDate().getTime()));
            return ps;
        }, keyHolder);
        expense.setId(keyHolder.getKey().intValue());
        return expense;
    }

    @Override
    public int update(int id, Expense expense) {
        return jdbcTemplate.update(UPDATE_EXPENSE,
                expense.getAmount(), expense.getCategory().getName(), expense.getDescription(), expense.getDate(), expense.getId()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update(DELETE_EXPENSE, id);
    }
}
