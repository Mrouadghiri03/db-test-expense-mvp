package com.example.dbtestmvp.di;

import com.example.dbtestmvp.data.repository.ExpenseRepository;
import com.example.dbtestmvp.presenter.AddExpensePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    AddExpensePresenter provideAddExpensePresenter(ExpenseRepository repository) {
        return new AddExpensePresenter(repository);
    }
}