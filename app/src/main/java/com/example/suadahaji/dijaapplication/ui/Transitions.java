package com.example.suadahaji.dijaapplication.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;

/**
 * Created by suadahaji
 */

public class Transitions {
    public static final String EXTRA_TRANSITION = "EXTRA_TRANSITION";
    public static final String TRANSITION_SLIDE_RIGHT = "SLIDE_RIGHT";
    public static final String TRANSITION_SLIDE_BOTTOM = "SLIDE_BOTTOM";


    public void startActivityWithOptions(Context context, Intent intent, Activity activity) {
        ActivityOptions transitionActivity = ActivityOptions.makeSceneTransitionAnimation(activity);
        context.startActivity(intent, transitionActivity.toBundle());
    }
}
