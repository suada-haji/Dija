package com.example.suadahaji.dijaapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suadahaji
 */

public class Book implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * In the writeToParcel method write all the class attributes
     */

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookName);
        dest.writeString(this.bookDescription);
        dest.writeString(this.bookAuthor);
        dest.writeString(this.bookImage);
        dest.writeString(this.publishedYear);
        dest.writeDouble(this.bookPrice);
        dest.writeDouble(this.bookRating);

    }

    /**
     * De-parcel the object(initialise the class attributes) in the constructor
     */
    public Book(Parcel in) {
        this.bookName = in.readString();
        this.bookDescription = in.readString();
        this.bookAuthor = in.readString();
        this.bookImage = in.readString();
        this.publishedYear = in.readString();
        this.bookPrice = in.readDouble();
        this.bookRating = in.readDouble();
    }

    /**
     * In the Parcel.Creator read the parcel data
     */
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };


}
