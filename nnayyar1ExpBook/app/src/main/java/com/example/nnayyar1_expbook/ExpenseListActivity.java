package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExpenseListActivity extends AppCompatActivity {
    private RecyclerView expenseListView;
    private ExpenseAdapter expenseAdaptor;
    private ArrayList<ExpenseRecord> expenses;

    private FloatingActionButton addExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_list_activity);

        expenseListView = findViewById(R.id.recyclerView);
        addExpenseButton = findViewById(R.id.addExpenseButton);

        expenseListView.setLayoutManager(new LinearLayoutManager(this));

        expenses = new ArrayList<>();
        expenses.add(new ExpenseRecord("Rent", new Date(), 123.0));

        expenseAdaptor = new ExpenseAdapter(expenses);

        expenseListView.setAdapter(expenseAdaptor);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseListActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });

    }
}