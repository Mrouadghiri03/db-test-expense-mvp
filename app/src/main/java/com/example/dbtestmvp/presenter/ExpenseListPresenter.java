package com.example.dbtestmvp.presenter;

import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.data.repository.ExpenseRepository;
import com.example.dbtestmvp.view.list.ExpenseListContract;

import java.util.List;

import javax.inject.Inject;

public class ExpenseListPresenter implements ExpenseListContract.Presenter {

    private ExpenseListContract.View view;
    private ExpenseRepository repository;

    @Inject
    public ExpenseListPresenter(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void attachView(ExpenseListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadExpenses() {
        List<Expense> expenses = repository.getExpenses();
        view.showExpenses(expenses);
        view.showTotal(totalExpenses());
    }

    @Override
    public double totalExpenses() {
        List<Expense> expenses=repository.getExpenses();
        double totalExpenses=expenses.stream().mapToDouble(Expense::getAmount).sum();
        return totalExpenses;
    }

    @Override
    public void delete(Expense expense) {
        repository.delete(expense);  // Appelle DAO
        loadExpenses(); // Recharge la liste
        totalExpenses();    // Met à jour le total
    }
}