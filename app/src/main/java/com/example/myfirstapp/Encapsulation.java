package com.example.myfirstapp;

public class Encapsulation {

    private String firstName;
    private String lastName;
    private String adminToggle;

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAdminToggle() {
        return adminToggle;
    }

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        lastName = newLastName;
    }

    public void setAdminToggle(String newAdminToggle){
        adminToggle = newAdminToggle;
    }
}

