package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Calendar;

public class ViewExpenseActivity extends AppCompatActivity {
    private EditText expenseName;
    private EditText expenseCharge;
    private EditText expenseComment;
    private Button confirmButton;
    private Button deleteButton;
    private NumberPicker yearPicker;
    private NumberPicker monthPicker;
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
        expenseCharge = findViewById(R.id.viewExpenseCharge);
        expenseComment = findViewById(R.id.viewExpenseComment);
        yearPicker = findViewById(R.id.yearPicker);
        monthPicker = findViewById(R.id.monthPicker);

        // limit the max year and month to the current year and month
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;

        yearPicker.setMinValue(2020);
        yearPicker.setMaxValue(currentYear);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(currentMonth);

        expenseName.setText(name);
        yearPicker.setValue(Integer.parseInt(monthStarted.split("-")[0]));
        monthPicker.setValue(Integer.parseInt(monthStarted.split("-")[1]));
        expenseCharge.setText(monthlyCharge);
        expenseComment.setText(comment);

        confirmButton = findViewById(R.id.confirmChangesButton);
        deleteButton = findViewById(R.id.deleteButton);

        // Send edited information back to the expense list activity
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                intent.putExtra("position", position);
                setResult(2, intent);

                finish();
            }
        });

        // send the position of the expense to be deleted back to the expense list activity
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