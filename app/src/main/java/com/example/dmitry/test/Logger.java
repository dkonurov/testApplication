package com.example.dmitry.test;


import android.util.Log;

public class Logger {

    public static void d(Object object, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(object.getClass().getSimpleName(), message);
        }
    }
}
