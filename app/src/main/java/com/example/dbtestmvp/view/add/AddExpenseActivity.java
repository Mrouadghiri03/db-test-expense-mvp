package com.example.dbtestmvp.view.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dbtestmvp.MyApplication;
import com.example.dbtestmvp.R;
import com.example.dbtestmvp.presenter.AddExpensePresenter;
import com.example.dbtestmvp.view.list.ExpenseListActivity;

import javax.inject.Inject;

public class AddExpenseActivity extends AppCompatActivity implements AddExpenseContract.View {

    private EditText etTitle, etAmount;
    private Button btnAdd,btnToList;

    @Inject
    AddExpensePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // Injection Dagger
        ((MyApplication) getApplication())
                .getAppComponent()
                .inject(this);

        // Bind Views
        etTitle = findViewById(R.id.etTitle);
        etAmount = findViewById(R.id.etAmount);
        btnAdd = findViewById(R.id.btnAdd);
        btnToList=findViewById(R.id.btnGoToList);


        // Attacher la view au presenter
        presenter.attachView(this);

        btnAdd.setOnClickListener(v -> presenter.onAddClicked());

        btnToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddExpenseActivity.this, ExpenseListActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getTitleInput() {
        return etTitle.getText().toString();
    }

    @Override
    public String getAmountInput() {
        return etAmount.getText().toString();
    }
}