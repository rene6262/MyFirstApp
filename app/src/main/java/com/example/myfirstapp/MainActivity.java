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
        if (firstName.length()==0) {
            editFirst.requestFocus();
            editFirst.setError("Please Enter a Name");
        } else if(!firstName.matches("[a-zA-Z]+")){
            editFirst.requestFocus();
            editFirst.setError("Enter Valid Characters Only");
        }
        intent.putExtra("editFirst", firstName);

        //Last Name
        EditText editLast = (EditText) findViewById(R.id.editLast);
        String lastName = editLast.getText().toString().trim();
        if (lastName.length()==0) {
            editLast.requestFocus();
            editLast.setError("Please Enter a Name");
        } else if(!firstName.matches("[a-zA-Z]+")){
            editLast.requestFocus();
            editLast.setError("Enter Valid Characters Only");
        }
        intent.putExtra("editLast", lastName);

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

        intent.putExtra("adminCheck", adminStatus);
        intent.putExtra("adminToggle", adminToggle);

        if (firstName.length()!=0 & lastName.length()!=0) {
            startActivity(intent);
        }
    }

}