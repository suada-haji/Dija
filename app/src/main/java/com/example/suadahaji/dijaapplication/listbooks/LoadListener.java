package com.example.suadahaji.dijaapplication.listbooks;

import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public interface LoadListener {
    void onFinished(ArrayList<Book> books);
    void displayErrorState();
    void displayEmptyState();
}
