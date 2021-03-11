package com.mcardenas.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4698hlpSKW1RIMJ8g0IcGGPWST3XsnygdJxPVufS")
                .clientKey("ORqP7d66CJ9zTmMtYRSnqGqft1Qkp8cSbmxI94eh")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
