package com.example.dbtestmvp.view.add;

public interface AddExpenseContract {

    interface View {
        void showMessage(String message);
        String getTitleInput();
        String getAmountInput();

        void setTitleInput();

        void setAmountInput();
    }

    interface Presenter {
        void onAddClicked();
    }
}