package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

public class InvalidNameException extends Exception{
    public Activity activityError;
    String errorMessage;


    public InvalidNameException(MainActivity mainActivity) throws InvalidNameException {
        super();
        this.activityError = mainActivity;
        Intent intent = new Intent(this.activityError, MainActivity.class);
        //First Name
        EditText editFirst = (EditText) this.activityError.findViewById(R.id.editFirst);
        String firstName = editFirst.getText().toString().trim();
        editFirst.requestFocus();
        editFirst.setError("Please Enter a Name");
        // Last Name
        EditText editLast = (EditText) this.activityError.findViewById(R.id.editLast);
        String lastName = editLast.getText().toString().trim();
        editLast.requestFocus();
        editLast.setError("Please Enter a Name");


        User user = (User) mainActivity.getIntent().getSerializableExtra(MainActivity.INTENT_USER_KEY);
        User saveData = new User(firstName, lastName, mainActivity.isAdmin);

        intent.putExtra(mainActivity.INTENT_USER_KEY, saveData);
    }

    public InvalidNameException(String errorMessage, Throwable errorCause) {
        super(errorMessage, errorCause);

        this.errorMessage = errorMessage;
        //this.errorCause = errorCause;
    }
}




