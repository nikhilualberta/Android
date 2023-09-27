package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddExpenseActivity extends AppCompatActivity {
    private EditText expenseName;
    private EditText expenseCharge;
    private EditText expenseComment;
    private Button addExpenseButton;
    private NumberPicker yearPicker;
    private NumberPicker monthPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        expenseName = findViewById(R.id.expenseName);
        expenseCharge = findViewById(R.id.expenseCharge);
        expenseComment = findViewById(R.id.expenseComment);
        addExpenseButton = findViewById(R.id.addExpenseButton);
        yearPicker = findViewById(R.id.yearPicker);
        monthPicker = findViewById(R.id.monthPicker);

        yearPicker.setMinValue(2010);
        yearPicker.setMaxValue(2030);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get all of the user input for adding a new expense and send it to the expense
                // list activity
                String name = expenseName.getText().toString();
                String month = "" + monthPicker.getValue();
                if (1 <= monthPicker.getValue() && monthPicker.getValue() <= 9){
                   month = "0" + monthPicker.getValue();
                }
                String monthStarted = yearPicker.getValue() + "-" + month;
                double monthlyCharge = Double.parseDouble(expenseCharge.getText().toString());
                String comment = expenseComment.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ExpenseListActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("monthStarted", monthStarted);
                intent.putExtra("monthlyCharge", monthlyCharge);
                intent.putExtra("comment", comment);
                setResult(1, intent);

                finish();
            }
        });
    }
}