package com.example.suadahaji.dijaapplication.listbooks;

import android.widget.ImageView;

import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public interface MainView {

    void showProgressBar();

    void hideProgressBar();

    void setBooks(ArrayList<Book> books);


    void showErrorMessage();

    void showEmptyStateMessage();

    void navigateToHome(int pos, Book book, ImageView imageView);
}
