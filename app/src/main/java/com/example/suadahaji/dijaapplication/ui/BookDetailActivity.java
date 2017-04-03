package com.example.suadahaji.dijaapplication.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BookDetailActivity extends AppCompatActivity {

    @BindView(R.id.book_detail_image)
    ImageView bookImage;

    @OnClick(R.id.back_button)
    void previousActivity() {
        Intent intent = new Intent(BookDetailActivity.this, ListBooksActivity.class);
        startActivity(intent);
        finish();
    }

    @BindView(R.id.fab_cart)
    FloatingActionButton fabCart;

    @BindView(R.id.book_detail_price)
    TextView bookPrice;

    @BindView(R.id.book_detail_name)
    TextView bookName;

    @BindView(R.id.book_detail_author)
    TextView bookAuthor;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.book_detail_date)
    TextView bookDate;

    @BindView(R.id.book_detail_description)
    TextView bookDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        ButterKnife.bind(this);

        bookPrice.setTypeface(BooksApplication.LATO_REGULAR);
        bookDescription.setTypeface(BooksApplication.LATO_REGULAR);
        bookName.setTypeface(BooksApplication.LATO_BOLD);
        description.setTypeface(BooksApplication.LATO_BOLD);
        bookDate.setTypeface(BooksApplication.LATO_BOLD);
        bookAuthor.setTypeface(BooksApplication.LATO_LIGHT);

        Book book = getIntent().getParcelableExtra("currentBook");

        Picasso.with(this).load(book.getBookImage()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
               assert  bookImage != null;
                bookImage.setImageBitmap(bitmap);
                Palette.from(bitmap)
                        .generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                Palette.Swatch textSwatch = palette.getVibrantSwatch();
                                if (fabCart.getBackgroundTintList() != null) {
                                    fabCart.setBackgroundTintList(ColorStateList.valueOf(textSwatch.getRgb()));
                                }
                            }
                        });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });


        bookPrice.setText(getString(R.string.price_annotate) + Double.toString(book.getBookPrice()));
        bookDescription.setText(book.getBookDescription());
        bookName.setText(book.getBookName());
        bookDate.setText(book.getPublishedYear());
        bookAuthor.setText(getString(R.string.author_annotate) + book.getBookAuthor());

        fabCart.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
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