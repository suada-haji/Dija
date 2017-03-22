package com.example.suadahaji.dijaapplication.dagger;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by suadahaji
 */

public class BooksApplication extends Application {
    private AppComponent appComponent;
    public static Typeface ROBOTO_MEDIUM;
    public static Typeface ROBOTO_REGULAR;
    public static Typeface LATO_REGULAR;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
        initFonts();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initFonts() {
        ROBOTO_MEDIUM = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        ROBOTO_REGULAR = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        LATO_REGULAR = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");
    }
}
