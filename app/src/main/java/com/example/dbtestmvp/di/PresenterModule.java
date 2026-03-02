package com.example.dbtestmvp.di;

import com.example.dbtestmvp.data.repository.ExpenseRepository;
import com.example.dbtestmvp.presenter.AddExpensePresenter;

import com.example.dbtestmvp.presenter.ExpenseListPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    AddExpensePresenter provideAddExpensePresenter(ExpenseRepository repository) {
        return new AddExpensePresenter(repository);
    }
    @Provides
    ExpenseListPresenter provideExpenseListPresenter(ExpenseRepository repository) {
        return new ExpenseListPresenter(repository);
    }
}