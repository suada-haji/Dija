package com.example.suadahaji.dijaapplication.mvp_books;

import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public interface MainView {

    void setBooks(ArrayList<Book> books);

    void showMessage(Book book);

    void showErrorMessage();
}
