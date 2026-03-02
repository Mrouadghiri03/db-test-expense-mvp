package com.example.dbtestmvp.data.local;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private double amount;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
//getters w setters mn 3nd lambook




}