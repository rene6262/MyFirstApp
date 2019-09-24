package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //First Name
        EditText editFirst = (EditText) findViewById(R.id.editFirst);
        String firstName = editFirst.getText().toString().trim();

        //Last Name
        EditText editLast = (EditText) findViewById(R.id.editLast);
        String lastName = editLast.getText().toString().trim();

        //Admin Control
        Switch adminSwitch = (Switch) findViewById(R.id.adminSwitch);
        String adminStatus, adminToggle;
        if (adminSwitch.isChecked()){
            adminStatus = adminSwitch.getTextOn().toString();
            adminToggle = getString(R.string.admin_toggle_on);
        } else {
            adminStatus = adminSwitch.getTextOff().toString();
            adminToggle = getString(R.string.admin_toggle_off);
        }


        //Encapsulate Data
        Encapsulation saveData = new Encapsulation();
        saveData.setFirstName(firstName);
        saveData.setLastName(lastName);
        saveData.setAdminToggle(adminToggle);

        //Validation
        if (firstName.isEmpty()) {
            editFirst.requestFocus();
            editFirst.setError("Please Enter a Name");
        } else if(!firstName.matches("[a-zA-Z]+")){
            editFirst.requestFocus();
            editFirst.setError("Enter Valid Characters Only");
        } else if(lastName.isEmpty()) {
            editLast.requestFocus();
            editLast.setError("Please Enter a Name");
        } else if(!firstName.matches("[a-zA-Z]+")){
            editLast.requestFocus();
            editLast.setError("Enter Valid Characters Only");
        } else {
            //Pass All Values Through The Intent
            intent.putExtra("editFirst", saveData.getFirstName());
            intent.putExtra("editLast", saveData.getLastName());
            intent.putExtra("adminCheck", adminStatus);
            intent.putExtra("adminToggle", saveData.getAdminToggle());
            startActivity(intent);
        }
    }
}