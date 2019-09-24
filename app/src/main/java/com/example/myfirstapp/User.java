package com.example.myfirstapp;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName, lastName, isAdmin;

    public User (String firstName, String lastName, String isAdmin){
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

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        lastName = newLastName;
    }

    public void setIsAdmin(String newIsAdmin){
        isAdmin = newIsAdmin;
    }



}

