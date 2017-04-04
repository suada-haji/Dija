package com.example.suadahaji.dijaapplication.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.graphics.Palette;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Callback;
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
        onBackPressed();
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

        final Transition fade = getWindow().getEnterTransition();
        fade.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                fabCart.animate().scaleX(1f).scaleY(1f);
                fade.removeListener(this);
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

        bookPrice.setTypeface(BooksApplication.LATO_REGULAR);
        bookDescription.setTypeface(BooksApplication.LATO_REGULAR);
        bookName.setTypeface(BooksApplication.LATO_BOLD);
        description.setTypeface(BooksApplication.LATO_BOLD);
        bookDate.setTypeface(BooksApplication.LATO_BOLD);
        bookAuthor.setTypeface(BooksApplication.LATO_LIGHT);

        Bundle extras = getIntent().getExtras();
        Book book = extras.getParcelable(ListBooksActivity.EXTRA_BOOK_ITEM);

        String bookImageUrl = book.getBookImage();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = extras.getString(ListBooksActivity.EXTRA_BOOK_IMAGE_TRANSITION_NAME);
            bookImage.setTransitionName(imageTransitionName);
        }

        Picasso.with(this)
                .load(bookImageUrl)
                .into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
               assert  bookImage != null;
                bookImage.setImageBitmap(bitmap);
                supportStartPostponedEnterTransition();
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
                supportStartPostponedEnterTransition();

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                supportStartPostponedEnterTransition();

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
    public void onBackPressed() {
        fabCart.animate().scaleX(0f).scaleY(0f)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        finishAfterTransition();
                    }
                });

    }
}