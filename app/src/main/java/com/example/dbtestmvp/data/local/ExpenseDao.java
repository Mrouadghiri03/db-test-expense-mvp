package com.example.dbtestmvp.data.local;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert
    void insert(Expense expense);

    @Query("SELECT * FROM expenses")
    List<Expense> getAllExpenses();

    @Delete
    void  delete(Expense expense);
}