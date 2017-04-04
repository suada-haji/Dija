package com.example.suadahaji.dijaapplication.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksHolder> {
    private static final String TAG = "BooksAdapter";

    private ArrayList<Book> books;
    private BookListener listener;
    int rowLayout;
    Context context;
    private int lastPosition = -1;


    public BooksAdapter(ArrayList<Book> bookArrayList, int rowLayout, Context context, BookListener listener) {
        this.books = bookArrayList;
        this.rowLayout = rowLayout;
        this.context = context;
        this.listener = listener;
    }


    public static class BooksHolder extends RecyclerView.ViewHolder {
        TextView bookName;
        TextView bookDescription;
        TextView bookAuthor;
        ImageView bookImage;
        TextView bookPrice;
        //LinearLayout relativeLayout;

        public BooksHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            //  bookDescription = (TextView) itemView.findViewById(R.id.book_description);
            bookAuthor = (TextView) itemView.findViewById(R.id.book_author);
            bookImage = (ImageView) itemView.findViewById(R.id.book_image);
            // bookPrice = (TextView) itemView.findViewById(R.id.book_price);

            //   relativeLayout = (LinearLayout) itemView.findViewById(R.id.activity_list_books);

            bookName.setTypeface(BooksApplication.ROBOTO_MEDIUM);
            //  bookDescription.setTypeface(BooksApplication.ROBOTO_REGULAR);
            bookAuthor.setTypeface(BooksApplication.LATO_REGULAR);
            //  bookPrice.setTypeface(BooksApplication.LATO_REGULAR);
        }

        public void bind(final Book book, final BookListener listener) {
            bookName.setText(book.getBookName());
            //  bookDescription.setText(book.getBookDescription());
            bookAuthor.setText("By " + book.getBookAuthor());
            //  bookPrice.setText("$ " + Double.toString(book.getBookPrice()));
            Picasso.with(itemView.getContext())
                    .load(book.getBookImage())
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            assert bookImage != null;
                            bookImage.setImageBitmap(bitmap);
                            Palette.from(bitmap)
                                    .generate(new Palette.PaletteAsyncListener() {
                                        @Override
                                        public void onGenerated(Palette palette) {
                                            Palette.Swatch backgroundColor = palette.getDarkMutedSwatch();
                                            // relativeLayout.setBackgroundColor(backgroundColor.getRgb());
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

            ViewCompat.setTransitionName(bookImage, book.getBookName());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onBookClicked(getAdapterPosition(), book, bookImage);
                    // listener.onBookClicked(book);
                }
            });
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(1000);
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }

    @Override
    public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(rowLayout, parent, false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.BooksHolder holder, final int position) {
        setAnimation(holder.itemView, position);
        holder.bind(books.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public interface BookListener {
        void onBookClicked(int pos, Book book, ImageView shareImageView);
    }
}