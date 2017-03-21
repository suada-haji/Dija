package com.example.suadahaji.dijaapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public class BookResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<Book> books;

    public BookResponse(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
