package com.example.myfirstapp;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public User (String firstName, String lastName, boolean isAdmin){
        setFirstName(firstName);
        setLastName(lastName);
        setIsAdmin(isAdmin);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        lastName = newLastName;
    }

    public void setIsAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }
}

