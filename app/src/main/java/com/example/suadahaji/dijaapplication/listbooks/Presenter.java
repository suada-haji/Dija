package com.example.suadahaji.dijaapplication.listbooks;

import android.widget.ImageView;

import com.example.suadahaji.dijaapplication.models.Book;

/**
 * Created by suadahaji
 */

public interface Presenter <V> {
    void attachedView(V view);

    void detachView();

    void onStart();

    void onItemSelected(int pos, Book book, ImageView sharedImageView);
}
