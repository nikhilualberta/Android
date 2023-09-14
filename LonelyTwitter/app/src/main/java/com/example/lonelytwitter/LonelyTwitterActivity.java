package com.example.lonelytwitter;
import java.util.ArrayList;

public class LonelyTwitterActivity {
    public static void main(String[] args) {
        ImportantTweet tweet = new ImportantTweet("");

        ImportantTweet importantTweet = new ImportantTweet("");

        importantTweet.setMessage("I am an important tweet");

        NormalTweet normalTweet = new NormalTweet("I am a normal tweet");

        ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

        tweetList.add(normalTweet);
        tweetList.add(importantTweet);

    }
}
