package com.example.nnayyar1_expbook;

import java.util.Date;

public class ExpenseRecord {
    String name;
    String monthStarted;
    double monthlyCharge;
    String comment;

    public ExpenseRecord(String name, String monthStarted, double monthlyCharge, String comment){
        this.name = name;
        this.monthStarted = monthStarted;
        this.monthlyCharge = monthlyCharge;
        this.comment = comment;
    }
    public ExpenseRecord(String name, String monthStarted, double monthlyCharge){
        this.name = name;
        this.monthStarted = monthStarted;
        this.monthlyCharge = monthlyCharge;
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