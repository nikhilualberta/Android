/*
References:
[1] for displaying a toast
 From: Stack Overflow
 Date of Publish: Aug 17, 2010
 URL: https://stackoverflow.com/questions/3500197/how-to-display-toast-in-android
 */
package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Calendar;

/*
This class manages adding new expenses to the expense list. It gets user input and validates
all the expense fields before sending the data back to the main expense list activity.
 */
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

        expenseCharge.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});

        // limit the max year to the current year
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;

        yearPicker.setMinValue(2020);
        yearPicker.setMaxValue(currentYear);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);

        yearPicker.setValue(currentYear);
        monthPicker.setValue(currentMonth);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get all of the user input for adding a new expense and send it to the expense
                // list activity
                String name = expenseName.getText().toString();
                String monthStarted = ExpenseValidator.formatDate(monthPicker, yearPicker);
                String charge = expenseCharge.getText().toString();
                String comment = expenseComment.getText().toString();
                if (!ExpenseValidator.checkName(name)){
                    // adapted from reference [1]
                    Toast.makeText(AddExpenseActivity.this, "Please fill in a name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!ExpenseValidator.checkDate(monthPicker, yearPicker)) {
                    Toast.makeText(AddExpenseActivity.this, "Cannot chose a date in the future", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!ExpenseValidator.checkCharge(charge)){
                    // adapted from reference [1]
                    Toast.makeText(AddExpenseActivity.this, "Please fill in the monthly charge amount", Toast.LENGTH_SHORT).show();
                    return;
                }
                double monthlyCharge = Double.parseDouble(charge);

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
