package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExpenseListActivity extends AppCompatActivity implements RecyclerViewInterface{
    private RecyclerView expenseListView;
    private ExpenseAdapter expenseAdapter;
    private ArrayList<ExpenseRecord> expenses;
    private TextView totalAmountTextView;
    private FloatingActionButton addExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);

        expenseListView = findViewById(R.id.recyclerView);
        addExpenseButton = findViewById(R.id.addExpenseButton);

        expenseListView.setLayoutManager(new LinearLayoutManager(this));
        expenses = new ArrayList<>();
        expenseAdapter = new ExpenseAdapter(expenses, this);
        expenseListView.setAdapter(expenseAdapter);

        // navigate to the add expense activity on click of the add button
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseListActivity.this, AddExpenseActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        // display total amount for the month
        totalAmountTextView = findViewById(R.id.totalAmount);
        totalAmountTextView.setText("$" + computeTotal());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // get the data from the add expense activity and add it to the expense list
        if (resultCode == 1) {
            String name = data.getStringExtra("name");
            String monthStarted = data.getStringExtra("monthStarted");
            double monthlyCharge = data.getDoubleExtra("monthlyCharge", 0);
            String comment = data.getStringExtra("comment");
            expenses.add(new ExpenseRecord(name, monthStarted, monthlyCharge, comment));
            expenseAdapter.notifyDataSetChanged();
        }
        // get the data from the view expense activity and modify an existing expense
        else if (resultCode == 2) {
            String name = data.getStringExtra("name");
            String monthStarted = data.getStringExtra("monthStarted");
            double monthlyCharge = data.getDoubleExtra("monthlyCharge", 0);
            String comment = data.getStringExtra("comment");
            int position = data.getIntExtra("position", 0);
            expenses.get(position).setName(name);
            expenses.get(position).setMonthStarted(monthStarted);
            expenses.get(position).setMonthlyCharge(monthlyCharge);
            expenses.get(position).setComment(comment);
            expenseAdapter.notifyDataSetChanged();
        }
        // get the data from the view expense activity and delete an expense
        else if (resultCode == 3) {
            int position = data.getIntExtra("position", 0);
            expenses.remove(position);
            expenseAdapter.notifyDataSetChanged();
        }
        totalAmountTextView.setText("$" + computeTotal());
    }

    @Override
    // navigate to the view expense activity on click of an expense in the list
    public void onItemClick(int position) {
        Intent intent = new Intent(ExpenseListActivity.this, ViewExpense.class);
        intent.putExtra("name", expenses.get(position).getName());
        intent.putExtra("monthStarted", expenses.get(position).getMonthStarted());
        intent.putExtra("monthlyCharge", expenses.get(position).getMonthlyCharge());
        intent.putExtra("comment", expenses.get(position).getComment());
        intent.putExtra("position", position);
        startActivityForResult(intent, 2);
    }

    public double computeTotal() {
        double total = 0.00;
        for (ExpenseRecord expense: expenses) {
            total += expense.getMonthlyCharge();
        }
        double roundedTotal = (double) Math.round(total * 100) / 100;
        return roundedTotal;
    }
}