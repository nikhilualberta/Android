/*
References:
[1] for displaying a toast
 From: Stack Overflow
 Date of Publish: Aug 17, 2010
 URL: https://stackoverflow.com/questions/3500197/how-to-display-toast-in-android

[2] for limiting decimal places on input
 From: Tutorials point
 Date of Publish: Jul 31, 2019
 URL: https://www.tutorialspoint.com/how-to-limit-decimal-places-in-android-edittext
 */
package com.example.nnayyar1_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        yearPicker.setMinValue(2020);
        yearPicker.setMaxValue(2025);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get all of the user input for adding a new expense and send it to the expense
                // list activity
                String name = expenseName.getText().toString();
                if (name.equals("")){
                    // adapted from reference [1]
                    Toast.makeText(AddExpenseActivity.this, "Please fill in a name", Toast.LENGTH_SHORT).show();
                    return;
                }
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

// class that serves as an input filter for getting the monthly charge from the user
// This class was adapted from reference [2]
class DecimalDigitsInputFilter implements InputFilter {
    private Pattern mPattern;

    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
        mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Matcher matcher = mPattern.matcher(dest);
        if (!matcher.matches()) {
            return "";
        }
        return null;
    }
}
