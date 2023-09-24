package com.example.nnayyar1_expbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends
        RecyclerView.Adapter<ExpenseAdapter.ViewHolder>{

    private ArrayList<ExpenseRecord> expenseList;
    public ExpenseAdapter(ArrayList<ExpenseRecord> expenseList, RecyclerViewInterface recyclerViewInterface) {
        this.expenseList = expenseList;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    private RecyclerViewInterface recyclerViewInterface;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView expenseLayoutName;
        public TextView expenseLayoutMonthStarted;
        public TextView expenseLayoutMonthlyCharge;
        public TextView expenseLayoutComment;


        public ViewHolder(View view, RecyclerViewInterface recyclerViewInterface) {
            super(view);
            expenseLayoutName = view.findViewById(R.id.expenseLayoutName);
            expenseLayoutMonthStarted = view.findViewById(R.id.expenseLayoutMonthStarted);
            expenseLayoutMonthlyCharge = view.findViewById(R.id.expenseLayoutMonthlyCharge);
            expenseLayoutComment = view.findViewById(R.id.expenseLayoutComment);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View expenseView = inflater.inflate(R.layout.expense_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(expenseView, recyclerViewInterface);
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
