package com.example.suadahaji.dijaapplication.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by suadahaji
 */

public class Typer {
    private static Typer typer = null;

    private HashMap<String, Typeface> fonts = null;
    private Context context = null;

    /**
     * Initialize font storage and connect the context.
     *
     * @param context the context of the activity.
     */
    private Typer(Context context) {
        this.fonts = new HashMap<>();
        this.context = context;
    }

    /**
     * Get the singleton base method.
     *
     * @param context the context of the activity.
     * @return the Typer class for the singleton.
     */
    public static Typer set(Context context) {
        if (typer == null)
            typer = new Typer(context);
        return typer;
    }

    /**
     * Get the proper Typeface depending on the parameter
     *
     * @param font the font name
     * @return the Typeface that corresponds to the name
     */
    public Typeface getFont(String font) {
        Typeface myFont = fonts.get(font);
        if (myFont == null) {
            myFont = Typeface.createFromAsset(context.getAssets(), "fonts/" + font);
            fonts.put(font, myFont);
        }
        return myFont;
    }
}
