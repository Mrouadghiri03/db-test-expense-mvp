package com.example.dbtestmvp.di;


import android.app.Application;
import androidx.room.Room;
import com.example.dbtestmvp.data.local.AppDatabase;
import com.example.dbtestmvp.data.local.ExpenseDao;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private Application application;

    public DatabaseModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    AppDatabase provideDatabase() {
        return Room.databaseBuilder(application,
                        AppDatabase.class, "expenses_db")
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    ExpenseDao provideExpenseDao(AppDatabase db) {
        return db.expenseDao();
    }
}