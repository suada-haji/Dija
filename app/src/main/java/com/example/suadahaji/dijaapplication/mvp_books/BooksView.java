package com.example.suadahaji.dijaapplication.mvp_books;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.api.ApiManager;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.example.suadahaji.dijaapplication.ui.BooksAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by suadahaji
 */

public class BooksView extends RelativeLayout implements BooksContract {

    @Inject
    ApiManager apiManager;

    private final RecyclerView recyclerView;

    BooksPresenter booksPresenter;

    private BooksAdapter booksAdapter;



    public BooksView(Context context) {
        this(context, null);
    }

    public BooksView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public BooksView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs);
    }
    public BooksView(Context context, @Nullable AttributeSet attrs) {
        super(context);
        ((BooksApplication) context.getApplicationContext()).getAppComponent().inject(this);

        final View view = LayoutInflater.from(context).inflate(R.layout.books_view, this, true);


        recyclerView = (RecyclerView) view.findViewById(R.id.books_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        booksPresenter = new BooksPresenter(apiManager, this);
        booksPresenter.fetchBooks();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        booksPresenter.unbind();
    }

    @Override
    public void onBookResponse(ArrayList<Book> books) {
        booksAdapter = new BooksAdapter(books, R.layout.book_list_view, getContext());
        recyclerView.setAdapter(booksAdapter);

    }

    @Override
    public void displayEmptyState() {
        findViewById(R.id.empty_state).setVisibility(VISIBLE);
    }

    @Override
    public void displayErrorState() {
        findViewById(R.id.error_state).setVisibility(VISIBLE);
    }
}
