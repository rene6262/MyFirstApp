package com.example.myfirstapp;

public class User {

    private String firstName;
    private String lastName;
    private String isAdmin;

    public User(){}

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


    @Override
    public String toString(){
        return "User:" + "First:" + firstName + "Last:" + lastName + "Admin" + isAdmin;
    }

}

