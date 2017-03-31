package com.example.suadahaji.dijaapplication.api;

import com.example.suadahaji.dijaapplication.models.BookResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suadahaji
 */

public interface ApiManager {
    @GET("0c4c72a73e401c624122e6f9e6bb5929/raw/ec1f931e108908c388e0c4419354f3448658f81b/blob.json")
    Observable<BookResponse> getBooks();

}
