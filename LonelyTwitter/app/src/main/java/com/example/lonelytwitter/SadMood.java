package com.example.lonelytwitter;
import java.util.Date;

public class SadMood extends CurrentMood{
    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "I am sad";
    }
}
