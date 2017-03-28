package com.example.suadahaji.dijaapplication.listbooks;

import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public interface MainView {

    void setBooks(ArrayList<Book> books);

    void showMessage(Book book);

    void showErrorMessage();

    void showEmptyStateMessage();

    void navigateToHome(Book book);
}
