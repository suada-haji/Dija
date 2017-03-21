package com.example.suadahaji.dijaapplication.mvp_books;

import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public interface BooksContract {
    void onBookResponse(ArrayList<Book> books);
    void displayEmptyState();
    void displayErrorState();
}
