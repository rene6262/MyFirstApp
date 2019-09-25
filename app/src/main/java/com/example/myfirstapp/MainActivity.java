package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String INTENT_USER_KEY = "com.example.myfirstapp.MESSAGE";

    public boolean isAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) throws InvalidNameException {

        try{
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            InvalidNameException instance = new InvalidNameException(this);
            User user = (User) getIntent().getSerializableExtra(MainActivity.INTENT_USER_KEY);

            //First Name
            EditText editFirst = (EditText) findViewById(R.id.editFirst);
            String firstName = editFirst.getText().toString().trim();

            //Last Name
            EditText editLast = (EditText) findViewById(R.id.editLast);
            String lastName = editLast.getText().toString().trim();

            //Admin Control
            Switch adminSwitch = (Switch) findViewById(R.id.adminSwitch);
            String adminStatus;
            boolean isAdmin = adminSwitch.isChecked();
            if (adminSwitch.isChecked()){
                adminStatus = adminSwitch.getTextOn().toString();
            } else {
                adminStatus = adminSwitch.getTextOff().toString();
            }
            Toast.makeText(this, "Admin Access: " + adminStatus, Toast.LENGTH_LONG).show();

            //Encapsulate Data
            User saveData = new User(firstName, lastName, isAdmin);

            intent.putExtra(INTENT_USER_KEY, saveData);
            startActivity(intent);

        } catch (InvalidNameException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }









        //Validation
//        if (firstName.isEmpty()) {
//            editFirst.requestFocus();
//            editFirst.setError("Please Enter a Name");
//        } else if(!firstName.matches("[a-zA-Z]+")){
//            editFirst.requestFocus();
//            editFirst.setError("Enter Valid Characters Only");
//        } else if(lastName.isEmpty()) {
//            editLast.requestFocus();
//            editLast.setError("Please Enter a Name");
//        } else if(!firstName.matches("[a-zA-Z]+")){
//            editLast.requestFocus();
//            editLast.setError("Enter Valid Characters Only");
//        } else {
//            //Pass All Values Through The Intent
//            intent.putExtra(INTENT_USER_KEY, saveData);
//            startActivity(intent);
//        }
    }
}