package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayMessageActivity extends AppCompatActivity {

    Switch adminSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();

        User User = (User) getIntent().getSerializableExtra("User");

        // Get First Name
        String firstName = User.getFirstName();
        TextView textFirst = findViewById(R.id.textFirst);
        textFirst.setText(firstName);
        // Get Last Name
        String lastName = User.getLastName();
        TextView textLast = findViewById(R.id.textLast);
        textLast.setText(lastName);
        // Get Admin Toggle
        String isAdmin = User.getIsAdmin();
        adminSwitch = (Switch) findViewById(R.id.adminSwitch);
        TextView adminText = findViewById(R.id.adminText);
        adminText.setText(isAdmin);
    }
}
