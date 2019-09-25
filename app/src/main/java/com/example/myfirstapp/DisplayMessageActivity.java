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
        User user = (User) getIntent().getSerializableExtra(MainActivity.INTENT_USER_KEY);

        try {
            // Get First Name
            String firstName = user.getFirstName();
            TextView textFirst = findViewById(R.id.textFirst);
            textFirst.setText(firstName);

            // Get Last Name
            String lastName = user.getLastName();
            TextView textLast = findViewById(R.id.textLast);
            textLast.setText(lastName);

            // Get Admin Toggle
            boolean isAdmin = user.getIsAdmin();
            String adminStatus;
            adminSwitch = (Switch) findViewById(R.id.adminSwitch);
            if (isAdmin) {
                adminStatus = getString(R.string.admin_toggle_on);
            } else {
                adminStatus = getString(R.string.admin_toggle_off);
            }
            TextView adminText = findViewById(R.id.adminText);
            adminText.setText(adminStatus);
        }
        catch (NullPointerException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
