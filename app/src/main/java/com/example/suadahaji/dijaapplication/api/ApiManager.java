package com.example.suadahaji.dijaapplication.api;

import com.example.suadahaji.dijaapplication.models.BookResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suadahaji
 */

public interface ApiManager {
    @GET("353a0b5fcabebf53adf0b0d44cc512b3/raw/ec675ad39fe4d37bfb8e6acbd36154f9123b3a8a/blob.json")
    Observable<BookResponse> getBooks();

}
