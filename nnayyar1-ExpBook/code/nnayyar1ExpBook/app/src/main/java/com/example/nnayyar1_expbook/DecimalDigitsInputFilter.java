/*
References:
[1] for limiting decimal places on input
 From: Tutorials point
 Date of Publish: Jul 31, 2019
 URL: https://www.tutorialspoint.com/how-to-limit-decimal-places-in-android-edittext
 */
package com.example.nnayyar1_expbook;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
class that serves as an input filter for getting the monthly charge from the user
This class was adapted from reference [1]
 */
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