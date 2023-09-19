package com.example.nnayyar1_expbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends
        RecyclerView.Adapter<ExpenseAdapter.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView expenseLayoutName;
        public TextView expenseLayoutMonthStarted;
        public TextView expenseLayoutMonthlyCharge;
        public TextView expenseLayoutComment;

        public ViewHolder(View view) {
            super(view);
            expenseLayoutName = view.findViewById(R.id.expenseLayoutName);
            expenseLayoutMonthStarted = view.findViewById(R.id.expenseLayoutMonthStarted);
            expenseLayoutMonthlyCharge = view.findViewById(R.id.expenseLayoutMonthlyCharge);
            expenseLayoutComment = view.findViewById(R.id.expenseLayoutComment);
        }
    }
    private ArrayList<ExpenseRecord> expenseList;
    public ExpenseAdapter(ArrayList<ExpenseRecord> expenseList) {
        this.expenseList = expenseList;
    }

    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View expenseView = inflater.inflate(R.layout.expense_row_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(expenseView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ViewHolder holder, int position) {
        ExpenseRecord expense = expenseList.get(position);

        // Bind the data to the views
        holder.expenseLayoutName.setText(expense.getName());
        holder.expenseLayoutMonthStarted.setText(expense.getMonthStarted().toString());
        holder.expenseLayoutMonthlyCharge.setText(expense.getMonthlyCharge()+"");
        holder.expenseLayoutComment.setText(expense.getComment());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }
}
