package com.example.suadahaji.dijaapplication.listbooks;

import com.example.suadahaji.dijaapplication.models.Book;

/**
 * Created by suadahaji
 */

public interface Presenter <V> {
    void attachedView(V view);

    void detachView();

    void onResume();

    void onItemSelected(Book book);
}
