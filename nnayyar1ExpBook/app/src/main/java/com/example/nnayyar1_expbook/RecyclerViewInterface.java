/*
References:
[1] for setting up the onClick for recycleViewer
 From: Practical Coding
 Date of Publish: Oct 29, 2021
 URL: https://www.youtube.com/watch?v=7GPUpvcU1FE
 */
package com.example.nnayyar1_expbook;

/*
This class declares the interface for our ExpenseListActivity to allow us to click on items in
our recycle viewer.
 */
public interface RecyclerViewInterface {
    void onItemClick(int position);
}
