package com.example.suadahaji.dijaapplication.dagger;

import com.example.suadahaji.dijaapplication.api.ApiModule;

import dagger.Component;

/**
 * Component provides required dependencies which are defined in modules
 *
 * It determines which modules it uses.
 */

@Component(modules = { AppModule.class, ApiModule.class })
public interface AppComponent {
    void inject(BooksApplication booksApplication);

    final class Initializer {
        /**
         * Initialise whole dependency
         */

        private Initializer() {
        } // No instances.

        static AppComponent init(BooksApplication app) {
            /**
             * Done in your application class, to keep the instance  throughout application’s lifecycle.
             */

            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
