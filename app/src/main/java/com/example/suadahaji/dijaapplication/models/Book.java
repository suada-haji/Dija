package com.example.suadahaji.dijaapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suadahaji
 */

public class Book {

    @SerializedName("book_name")
    @Expose
    private String bookName;

    @SerializedName("book_description")
    @Expose
    private String bookDescription;

    @SerializedName("book_author")
    @Expose
    private String bookAuthor;

    @SerializedName("published_year")
    @Expose
    private String publishedYear;

    @SerializedName("book_image")
    @Expose
    private String bookImage;

    @SerializedName("rating")
    @Expose
    private double bookRating;

    @SerializedName("price")
    @Expose
    private double bookPrice;

    public Book () {

    }

    public Book(String bookName, String bookDescription, String bookAuthor, String bookImage, String publishedYear, double bookPrice, double bookRating) {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookImage = bookImage;
        this.publishedYear = publishedYear;
        this.bookPrice = bookPrice;
        this.bookRating = bookRating;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public double getBookRating() {
        return bookRating;
    }

    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
