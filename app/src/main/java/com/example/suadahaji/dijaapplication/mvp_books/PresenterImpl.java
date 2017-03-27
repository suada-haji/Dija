package com.example.suadahaji.dijaapplication.mvp_books;

import com.example.suadahaji.dijaapplication.api.ApiManager;
import com.example.suadahaji.dijaapplication.models.Book;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by suadahaji
 */

public class PresenterImpl implements Presenter<MainView>, LoadListener {


    private MainView mainView;
    private InteractorImpl interactor;

    public PresenterImpl(ApiManager apiManager) {
        interactor = new InteractorImpl(apiManager, this);
    }

    @Override
    public void attachedView(MainView view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }

        mainView = view;

    }

    @Override
    public void detachView() {
        mainView = null;
        interactor.unbind();
    }

    @Override
    public void onResume() {
        interactor.loadItems();
    }

    @Override
    public void onItemSelected(Book book) {
        mainView.showMessage(book);
    }


    @Override
    public void onFinished(ArrayList<Book> books) {
        mainView.setBooks(books);
    }

    @Override
    public void displayErrorState() {
        mainView.showErrorMessage();

    }


}
