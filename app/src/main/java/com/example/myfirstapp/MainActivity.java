package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;


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
        String adminStatus, isAdmin;
        if (adminSwitch.isChecked()){
            adminStatus = adminSwitch.getTextOn().toString();
            isAdmin = getString(R.string.admin_toggle_on);
        } else {
            adminStatus = adminSwitch.getTextOff().toString();
            isAdmin = getString(R.string.admin_toggle_off);
        }

        //Encapsulate Data
        User saveData = new User();
        saveData.setFirstName(firstName);
        saveData.setLastName(lastName);
        saveData.setIsAdmin(isAdmin);

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
            Bundle userDataBundle = new Bundle();

            userDataBundle.putString("editFirst", saveData.getFirstName());
            userDataBundle.putString("editLast", saveData.getLastName());
            userDataBundle.putString("adminCheck", adminStatus);
            userDataBundle.putString("adminToggle", saveData.getIsAdmin());

            intent.putExtras(userDataBundle);

//            intent.putExtra("user_data", (Parcelable) saveData);

            startActivity(intent);
        }
    }
}