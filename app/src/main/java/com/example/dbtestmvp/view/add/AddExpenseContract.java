package com.example.dbtestmvp.view.add;

public interface AddExpenseContract {

    interface View {
        void showMessage(String message);
        String getTitleInput();
        String getAmountInput();
    }

    interface Presenter {
        void onAddClicked();
    }
}