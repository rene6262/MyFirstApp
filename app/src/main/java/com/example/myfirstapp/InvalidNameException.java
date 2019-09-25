package com.example.myfirstapp;

import android.app.Activity;
import android.util.Log;

public class InvalidNameException extends Exception{

    private String name;
    private static final String TAG = "InvalidName";

    public InvalidNameException(String name, String message) {
        super(message, null);
        this.name = name;
    }

    public String getName(){
        Log.d(TAG, name);
        return name;
    }
}




