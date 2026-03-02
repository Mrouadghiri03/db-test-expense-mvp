package com.example.dbtestmvp.view.add;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dbtestmvp.MyApplication;
import com.example.dbtestmvp.R;
import com.example.dbtestmvp.presenter.AddExpensePresenter;

import javax.inject.Inject;

public class AddExpenseActivity extends AppCompatActivity implements AddExpenseContract.View {

    private EditText etTitle, etAmount;
    private Button btnAdd;

    @Inject
    AddExpensePresenter presenter;

   /* @Override
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

        // Attacher la view au presenter
        presenter.attachView(this);

        btnAdd.setOnClickListener(v -> presenter.onAddClicked());
    }

    */

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