package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

public class InvalidNameException extends Exception{
    public Activity activityError;
    private String errorMessage;


    public InvalidNameException(MainActivity mainActivity) {
        super();
    }

    public InvalidNameException(String errorMessage, Throwable errorCause) {
        super(errorMessage, errorCause);

        this.errorMessage = errorMessage;
        //this.errorCause = errorCause;
    }
}




