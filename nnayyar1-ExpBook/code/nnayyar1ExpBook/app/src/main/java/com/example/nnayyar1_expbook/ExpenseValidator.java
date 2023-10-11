package com.example.nnayyar1_expbook;

import android.widget.NumberPicker;

import java.util.Calendar;

/*
This class is used by the AddExpenseActivity and ViewExpenseActivity classes to make sure all the
user input is valid and in the correct formats for adding or editing expenses.
 */
public class ExpenseValidator {
    public static boolean checkName(String name) {
        return !name.equals("");
    }
    public static boolean checkDate(NumberPicker monthPicker, NumberPicker yearPicker) {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        if (yearPicker.getValue() == currentYear && monthPicker.getValue() > currentMonth) {
            return false;
        }
        else return true;
    }
    public static String formatDate(NumberPicker monthPicker, NumberPicker yearPicker) {
        String month = "" + monthPicker.getValue();
        if (1 <= monthPicker.getValue() && monthPicker.getValue() <= 9){
            month = "0" + monthPicker.getValue();
        }
        return yearPicker.getValue() + "-" + month;
    }
    public static boolean checkCharge(String charge) {
        return !charge.equals("");
    }
}
