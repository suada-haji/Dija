package com.example.suadahaji.dijaapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.api.ApiManager;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.example.suadahaji.dijaapplication.mvp_books.MainView;
import com.example.suadahaji.dijaapplication.mvp_books.PresenterImpl;

import java.util.ArrayList;

import javax.inject.Inject;

public class ListBooksActivity extends AppCompatActivity implements MainView, BooksAdapter.BookListener {

    private RecyclerView recyclerView;
    private PresenterImpl presenter;
    private BooksAdapter adapter;

    @Inject
    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_view);

        getSupportActionBar().setTitle("Dija Books");

        ((BooksApplication) getApplicationContext()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);

        presenter = new PresenterImpl(apiManager);
        presenter.attachedView(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void setBooks(ArrayList<Book> books) {
        adapter = new BooksAdapter(books, R.layout.book_list_view, this, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showMessage(Book book) {
        Toast.makeText(this, String.format("You clicked on %s",  book.getBookName()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage() {
        findViewById(R.id.error_state).setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyStateMessage() {
        findViewById(R.id.empty_state).setVisibility(View.VISIBLE);
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.detachView();
        super.onDetachedFromWindow();
    }

    @Override
    public void onBookClicked(Book book) {
        presenter.onItemSelected(book);
    }
}
