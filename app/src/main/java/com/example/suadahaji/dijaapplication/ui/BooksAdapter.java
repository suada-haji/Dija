package com.example.suadahaji.dijaapplication.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.dagger.BooksApplication;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksHolder>{
    private static final String TAG = "BooksAdapter";

    private ArrayList<Book> books;
    private BookListener listener;
    int rowLayout;
    Context context;

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

        public BooksHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            bookDescription = (TextView) itemView.findViewById(R.id.book_description);
            bookAuthor = (TextView) itemView.findViewById(R.id.book_author);
            bookImage = (ImageView) itemView.findViewById(R.id.book_image);
            bookPrice = (TextView) itemView.findViewById(R.id.book_price);

            bookName.setTypeface(BooksApplication.ROBOTO_MEDIUM);
            bookDescription.setTypeface(BooksApplication.ROBOTO_REGULAR);
            bookAuthor.setTypeface(BooksApplication.LATO_REGULAR);
            bookPrice.setTypeface(BooksApplication.LATO_REGULAR);
        }

        public void bind(final Book book, final BookListener listener) {
            bookName.setText(book.getBookName());
            bookDescription.setText(book.getBookDescription());
            bookAuthor.setText("By " + book.getBookAuthor());
            bookPrice.setText("$ " + Double.toString(book.getBookPrice()));
            Picasso.with(itemView.getContext()).load(book.getBookImage()).into(bookImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onBookClicked(book);
                }
            });
        }
    }

    @Override
    public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(rowLayout, parent, false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.BooksHolder holder, final int position) {
        holder.bind(books.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public interface BookListener {
        void onBookClicked(Book book);
    }
}