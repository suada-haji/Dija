package com.example.suadahaji.dijaapplication.mvp_books;

import com.example.suadahaji.dijaapplication.api.ApiManager;
import com.example.suadahaji.dijaapplication.models.Book;
import com.example.suadahaji.dijaapplication.models.BookResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by suadahaji
 */

public class BooksPresenter {
    @Inject
    ApiManager apiManager;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    private BooksContract booksContract;

    public BooksPresenter(ApiManager apiManager, BooksContract contract) {
        this.apiManager = apiManager;
        this.booksContract = contract;
    }

    void fetchBooks() {
        final Observable<BookResponse> bookResponseObservable = apiManager.getBooks();
        compositeSubscription.add(bookResponseObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BookResponse>() {
                    @Override
                    public void call(BookResponse bookResponse) {
                        if (bookResponse == null || bookResponse.getBooks() == null || bookResponse.getBooks().size() == 0) {
                            booksContract.displayEmptyState();
                        }
                        ArrayList<Book> books = bookResponse.getBooks();
                        booksContract.onBookResponse(books);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        booksContract.displayErrorState();
                    }
                }));
    }

    void unbind() {
        compositeSubscription.unsubscribe();
    }


}
