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
        Intent intent = getIntent();

        String firstName = intent.getStringExtra("editFirst");
        TextView textFirst = findViewById(R.id.textFirst);
        textFirst.setText(firstName);

        String lastName = intent.getStringExtra("editLast");
        TextView textLast = findViewById(R.id.textLast);
        textLast.setText(lastName);

        String adminCheck = intent.getStringExtra("adminCheck");
        String adminToggle = intent.getStringExtra("adminToggle");
        adminSwitch = (Switch) findViewById(R.id.adminSwitch);
        TextView adminText = findViewById(R.id.adminText);
        adminText.setText(adminToggle);
        Toast.makeText(getApplicationContext(),"Admin Control: " + adminCheck, Toast.LENGTH_LONG).show();

    }
}
