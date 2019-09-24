package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("editText");
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        String message2 = intent.getStringExtra("editLast");
        TextView textLast = findViewById(R.id.textLast);
        textLast.setText(message2);
    }
}
