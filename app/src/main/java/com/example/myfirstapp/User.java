package com.example.myfirstapp;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private static final String TAG = "UserClass";

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

    public void setFirstName(String name) throws InvalidNameException {
        firstName = name;
        if(firstName.isEmpty())
            throw new InvalidNameException(firstName,"Name Could Not Be Submitted");
    }

    public void setLastName(String name) throws InvalidNameException {
        lastName = name;
        if(lastName.isEmpty())
            throw new InvalidNameException(lastName,"Name Could Not Be Submitted");
    }

    public void setIsAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }
}
