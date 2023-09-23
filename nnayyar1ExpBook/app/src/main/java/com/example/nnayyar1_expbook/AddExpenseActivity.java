package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
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
                setResult(RESULT_OK, intent);

                // Finish this activity
                finish();


            }
        });
    }
}