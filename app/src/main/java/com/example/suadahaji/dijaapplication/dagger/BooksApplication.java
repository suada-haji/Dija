package com.example.suadahaji.dijaapplication.dagger;

import android.app.Application;

/**
 * Created by suadahaji
 */

public class BooksApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
