package com.example.dbtestmvp.presenter;


import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.data.repository.ExpenseRepository;
import com.example.dbtestmvp.view.add.AddExpenseContract;

import javax.inject.Inject;

public class AddExpensePresenter implements AddExpenseContract.Presenter {

    private AddExpenseContract.View view;
    private ExpenseRepository repository;

    @Inject
    public AddExpensePresenter(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void attachView(AddExpenseContract.View view) {
        this.view = view;
    }

    @Override
    public void onAddClicked() {

        String title = view.getTitleInput();
        double amount = Double.parseDouble(view.getAmountInput());

        repository.addExpense(new Expense(title, amount));
        view.showMessage("Expense Added");
    }
}