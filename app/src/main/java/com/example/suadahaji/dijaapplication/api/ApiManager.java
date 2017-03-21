package com.example.suadahaji.dijaapplication.api;

import com.example.suadahaji.dijaapplication.models.BookResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suadahaji
 */

public interface ApiManager {
    @GET("ld6d53776216c2e28635a7a7d4fafe618/raw/ce1c5e674a51696c96b2333069dec3aca02eb8e8/books.json")
    Observable<BookResponse> getBooks();

}
