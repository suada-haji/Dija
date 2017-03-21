package com.example.suadahaji.dijaapplication.api;

import com.example.suadahaji.dijaapplication.dagger.qualifiers.ApiUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by suadahaji
 */

@Module
public class ApiModule {
    @Provides @Singleton @ApiUrl String provideApiUrl() {
        return "https://gist.githubusercontent.com/andela-shaji/";
    }

    @Provides @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .build();
    }

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, @ApiUrl String baseUrl) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Provides @Singleton ApiManager provideApiManager(Retrofit retrofit) {
        return retrofit.create(ApiManager.class);
    }

}
