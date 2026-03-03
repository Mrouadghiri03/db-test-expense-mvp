package com.example.dbtestmvp.data.local;


import android.os.Build;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private double amount;
    //private LocalDateTime dateTime;
    private long timestamp;//kaytstoka b ms

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


       this.timestamp=System.currentTimeMillis();


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


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void delete(Expense expense) {
    }
    @Override
    public String toString() {
        return "Titre: " + title + ", Montant: " + amount + "€, Date: " + timestamp;
    }
}