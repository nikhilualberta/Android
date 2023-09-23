package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddExpenseActivity extends AppCompatActivity {
    private EditText expenseName;
    private EditText expenseMonthStarted;
    private EditText expenseCharge;
    private EditText expenseComment;
    private Button addExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        expenseName = findViewById(R.id.expenseName);
        expenseMonthStarted = findViewById(R.id.expenseMonthStarted);
        expenseCharge = findViewById(R.id.expenseCharge);
        expenseComment = findViewById(R.id.expenseComment);
        addExpenseButton = findViewById(R.id.addExpenseButton);
    }
}