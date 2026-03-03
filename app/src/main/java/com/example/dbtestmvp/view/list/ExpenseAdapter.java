package com.example.dbtestmvp.view.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtestmvp.R;
import com.example.dbtestmvp.data.local.Expense;
import com.example.dbtestmvp.data.repository.ExpenseRepository;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<Expense> expenses;
    private OnExpenseDeleteListener deleteListener;


    private ExpenseRepository repository;
    @Inject
    public ExpenseAdapter(ExpenseRepository repository) {
        this.repository = repository;
    }
    public interface OnExpenseDeleteListener {
        void onDeleteClicked(Expense expense);
    }

    public ExpenseAdapter(List<Expense> expenses, OnExpenseDeleteListener listener) {
        this.expenses = expenses;
        this.deleteListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.tvTitle.setText(expense.getTitle());
        holder.tvAmount.setText(String.valueOf(expense.getAmount()));
        long timestamp = expense.getTimestamp();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate = sdf.format(new Date(timestamp));

        //holder.tvDate.setText(formattedDate);
        holder.tvDateTime.setText(formattedDate);
      /*  holder.ivDelete.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onDeleteClicked(expense);
                Log.d("DELETE", "Click delete");
                List<Expense> expenses = repository.getExpenses();

// Convertit tous les items en string et joint avec " | "
                String allExpenses = expenses.stream()
                        .map(Expense::toString)
                        .collect(Collectors.joining(" | "));

                Log.d("ALL_EXPENSES", allExpenses);
            }
        });

       */
        holder.ivDelete.setOnClickListener(v -> {
            if (deleteListener != null) {
                // Supprimer de la base via ton presenter / repository
                deleteListener.onDeleteClicked(expense);

                // Vérifier la position
                int positionToRemove = holder.getAdapterPosition();
                if (positionToRemove != RecyclerView.NO_POSITION) {
                    // Supprimer localement
                    expenses.remove(positionToRemove);
                    notifyItemRemoved(positionToRemove);

                    // Log de tous les items
                    String allExpenses = expenses.stream()
                            .map(Expense::toString)
                            .collect(Collectors.joining(" | "));
                    Log.d("ALL_EXPENSES", allExpenses);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAmount, tvDateTime;
        ImageView ivDelete;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvDateTime = itemView.findViewById(R.id.tvDate);
            ivDelete =  itemView.findViewById(R.id.ivDelete);

        }


    }

    // Mise à jour de la liste après suppression
    public void updateExpenses(List<Expense> updatedExpenses) {
        this.expenses = updatedExpenses;
        notifyDataSetChanged();
    }
}