package com.example.nnayyar1_expbook;

import java.util.Date;

/*
This class defines the expense record format.
 */
public class ExpenseRecord {
    private String name;
    private String monthStarted;
    private double monthlyCharge;
    private String comment;

    public ExpenseRecord(String name, String monthStarted, double monthlyCharge, String comment){
        this.name = name;
        this.monthStarted = monthStarted;
        this.monthlyCharge = monthlyCharge;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthStarted() {
        return monthStarted;
    }

    public void setMonthStarted(String monthStarted) {
        this.monthStarted = monthStarted;
    }

    public double getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
