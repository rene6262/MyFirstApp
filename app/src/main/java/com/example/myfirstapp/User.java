package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public User(String firstName, String lastName, boolean isAdmin) throws InvalidNameException {
        setFirstName(firstName);
        setLastName(lastName);
        setIsAdmin(isAdmin);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setFirstName(String newFirstName) throws InvalidNameException {
        firstName = newFirstName;
        if(firstName.isEmpty()) {
            throw new InvalidNameException("Name Could Not Be Submitted", new Throwable("Error"));
            //Toast.makeText(this, InvalidNameException.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            
        }
    }

    public void setLastName(String newLastName) throws InvalidNameException {
        lastName = newLastName;
        if(lastName.isEmpty()) {
            throw new InvalidNameException("Name Could Not Be Submitted", new Throwable("Error"));
            //editFirst.requestFocus();
            //editFirst.setError("Please Enter a Name");
        }
    }

    public void setIsAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }


}
