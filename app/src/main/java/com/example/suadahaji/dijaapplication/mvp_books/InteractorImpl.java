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

public class InteractorImpl implements Interactor {

    @Inject
    ApiManager apiManager;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    private LoadListener loadListener;

    public InteractorImpl(ApiManager apiManager, LoadListener loadListener) {
        this.apiManager = apiManager;
        this.loadListener = loadListener;
    }

    @Override
    public void loadItems() {
        final Observable<BookResponse> bookResponseObservable = apiManager.getBooks();

        compositeSubscription.add(bookResponseObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BookResponse>() {
                    @Override
                    public void call(BookResponse bookResponse) {
                        ArrayList<Book> books = bookResponse.getBooks();
                        loadListener.onFinished(books);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        loadListener.displayErrorState();
                    }
                })
        );
    }

    @Override
    public void unbind() {

    }
}
