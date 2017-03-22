package com.example.suadahaji.dijaapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.suadahaji.dijaapplication.R;

public class ListBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        getSupportActionBar().setTitle("Dija Books");

    }
}
