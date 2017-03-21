package com.example.suadahaji.dijaapplication.dagger;

import android.content.Context;

import com.example.suadahaji.dijaapplication.dagger.qualifiers.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Modules encapsulate knowledge of how to construct the objects you want to inject
 */

@Module
public class AppModule {
    private final BooksApplication booksApplication;
    AppModule(BooksApplication app) {
        this.booksApplication = app;
    }

    @Provides @ApplicationContext
    Context provideApplicationContext() {
        return booksApplication.getApplicationContext();
    }

}
