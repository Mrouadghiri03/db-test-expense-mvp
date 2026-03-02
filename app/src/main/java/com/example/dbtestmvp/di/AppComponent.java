package com.example.dbtestmvp.di;


import com.example.dbtestmvp.view.add.AddExpenseActivity;


import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {DatabaseModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(AddExpenseActivity activity);
}