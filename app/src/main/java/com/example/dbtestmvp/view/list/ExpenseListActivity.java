package com.example.dbtestmvp.view.list;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtestmvp.MyApplication;
import com.example.dbtestmvp.R;
import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.presenter.ExpenseListPresenter;
import com.example.dbtestmvp.view.add.AddExpenseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

public class ExpenseListActivity extends AppCompatActivity implements ExpenseListContract.View {

    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;

    private FloatingActionButton btnToAddExpense;

    private TextView tvTotalAmount;

    @Inject
    ExpenseListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);

        ((MyApplication) getApplication())
                .getAppComponent()
                .inject(this);

        recyclerView = findViewById(R.id.recyclerView);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.attachView(this);
        presenter.loadExpenses();

        btnToAddExpense = findViewById(R.id.btnGoToAddExpense);
        btnToAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpenseListActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showExpenses(List<Expense> expenses) {
        adapter = new ExpenseAdapter(expenses);
        recyclerView.setAdapter(adapter);

    }

    //il faut que je finis cette fonction pour que je affiche le montant total des expenses aussi
    //ajouter la date pour chaque transaction 
    @Override
    public void showTotal(Double total) {
        tvTotalAmount.setText(String.format("%.2f €", total));
    }
}