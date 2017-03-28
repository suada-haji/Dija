package com.example.suadahaji.dijaapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.models.Book;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Book book = getIntent().getParcelableExtra("currentBook");

        getSupportActionBar().setTitle(book.getBookName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // It will close current activity and return to previous
                startActivity(new Intent(this, ListBooksActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}