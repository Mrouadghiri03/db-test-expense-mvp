package com.example.dbtestmvp.data.repository;


import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.data.local.ExpenseDao;

import java.util.List;

import javax.inject.Inject;

public class ExpenseRepository {

    private ExpenseDao expenseDao;

    @Inject
    public ExpenseRepository(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public void addExpense(Expense expense) {
        expenseDao.insert(expense);
    }

    public List<Expense> getExpenses(){
        return  expenseDao.getAllExpenses();
    }

    public void delete(Expense expense){
        expenseDao.delete(expense);
    }
}