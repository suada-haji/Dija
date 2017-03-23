package com.example.suadahaji.dijaapplication.api;

import com.example.suadahaji.dijaapplication.models.BookResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suadahaji
 */

public interface ApiManager {
    @GET("3b0561062271123653f7569fbb941e20/raw/210ee4e48272eb3531b64a4eb4aa211ec647314a/6420cfdb-0af0-11e7-a0ba-d3c0c8656989.json")
    Observable<BookResponse> getBooks();

}
