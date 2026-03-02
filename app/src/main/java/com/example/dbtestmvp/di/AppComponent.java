package com.example.dbtestmvp.di;


import javax.inject.Singleton;

import com.example.dbtestmvp.view.add.AddExpenseActivity;
import com.example.dbtestmvp.view.list.ExpenseListActivity;
import dagger.Component;

@Singleton
@Component(modules = {DatabaseModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(AddExpenseActivity activity);

    void inject(ExpenseListActivity activity);
}
