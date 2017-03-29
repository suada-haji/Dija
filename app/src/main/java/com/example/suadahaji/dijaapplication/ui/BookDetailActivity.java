package com.example.suadahaji.dijaapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {

    private static final String TAG = "BookDetailActivity";

    ImageView bookImage;

    String bookImageUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookImage = (ImageView) findViewById(R.id.book_detail_image);

        Book book = getIntent().getParcelableExtra("currentBook");

      //  manageToolBar();


       /* if (null != toolbar) {
            toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  NavUtils.navigateUpFromSameTask(BookDetailActivity.this);
                    startActivity(new Intent(BookDetailActivity.this, ListBooksActivity.class));
                    finish();
                }
            });
        }*/


        bookImageUrl = book.getBookImage();

        Picasso.with(this).load(bookImageUrl).into(bookImage);

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BookDetailActivity.this, ListBooksActivity.class);
        startActivity(intent);
        finish();
    }

}