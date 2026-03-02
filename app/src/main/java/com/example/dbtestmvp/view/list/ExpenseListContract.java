package com.example.dbtestmvp.view.list;

import com.example.dbtestmvp.data.local.Expense;
import java.util.List;

public interface ExpenseListContract {

    interface View {
        void showExpenses(List<Expense> expenses);
    }

    interface Presenter {
        void loadExpenses();
    }
}