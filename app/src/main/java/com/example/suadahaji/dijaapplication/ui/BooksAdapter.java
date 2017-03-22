package com.example.suadahaji.dijaapplication.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suadahaji.dijaapplication.R;
import com.example.suadahaji.dijaapplication.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by suadahaji
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksHolder>{

    private ArrayList<Book> books;
    int rowLayout;
    Context context;

    public BooksAdapter(ArrayList<Book> bookArrayList, int rowLayout, Context context) {
        this.books = bookArrayList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public class BooksHolder extends RecyclerView.ViewHolder {
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
        }
    }

    @Override
    public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_list_view, parent, false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.BooksHolder holder, int position) {
        holder.bookName.setText(books.get(position).getBookName());
        holder.bookDescription.setText(books.get(position).getBookDescription());
        holder.bookAuthor.setText(books.get(position).getBookAuthor());
        holder.bookPrice.setText(Double.toString(books.get(position).getBookPrice()));
        Picasso.with(context).load(books.get(position).getBookImage()).into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}