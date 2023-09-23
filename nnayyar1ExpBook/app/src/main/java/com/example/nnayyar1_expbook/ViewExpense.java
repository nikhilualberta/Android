package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewExpense extends AppCompatActivity {
    private EditText expenseName;
    private EditText expenseMonthStarted;
    private EditText expenseCharge;
    private EditText expenseComment;
    private Button confirmButton;
    private Button deleteButton;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);

        // retrieve expense information from intent and display it in UI
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String monthStarted = intent.getStringExtra("monthStarted");
        String monthlyCharge = intent.getDoubleExtra("monthlyCharge", 0) + "";
        String comment = intent.getStringExtra("comment");
        position = intent.getIntExtra("position", 0);

        expenseName = findViewById(R.id.viewExpenseName);
        expenseMonthStarted = findViewById(R.id.viewExpenseMonthStarted);
        expenseCharge = findViewById(R.id.viewExpenseCharge);
        expenseComment = findViewById(R.id.viewExpenseComment);

        expenseName.setText(name);
        expenseMonthStarted.setText(monthStarted);
        expenseCharge.setText(monthlyCharge);
        expenseComment.setText(comment);

        confirmButton = findViewById(R.id.confirmChangesButton);
        deleteButton = findViewById(R.id.deleteButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = expenseName.getText().toString();
                String monthStarted = expenseMonthStarted.getText().toString();
                double monthlyCharge = Double.parseDouble(expenseCharge.getText().toString());
                String comment = expenseComment.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ExpenseListActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("monthStarted", monthStarted);
                intent.putExtra("monthlyCharge", monthlyCharge);
                intent.putExtra("comment", comment);
                intent.putExtra("position", position);
                setResult(2, intent);

                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ExpenseListActivity.class);
                intent.putExtra("position", position);
                setResult(3, intent);
                finish();
            }
        });
    }
}