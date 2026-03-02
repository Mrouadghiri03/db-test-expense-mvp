package com.example.dbtestmvp.view.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtestmvp.MyApplication;
import com.example.dbtestmvp.R;
import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.presenter.ExpenseListPresenter;

import java.util.List;

import javax.inject.Inject;

public class ExpenseListActivity extends AppCompatActivity implements ExpenseListContract.View {

    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.attachView(this);
        presenter.loadExpenses();
    }

    @Override
    public void showExpenses(List<Expense> expenses) {
        adapter = new ExpenseAdapter(expenses);
        recyclerView.setAdapter(adapter);
    }
}