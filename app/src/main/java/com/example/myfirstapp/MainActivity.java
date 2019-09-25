package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String INTENT_USER_KEY = "com.example.myfirstapp.MESSAGE";

    public boolean isAdmin;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) throws InvalidNameException {

        //First Name
        final EditText editFirst = findViewById(R.id.editFirst);
        final String firstName = editFirst.getText().toString().trim();

        //Last Name
        final EditText editLast = findViewById(R.id.editLast);
        final String lastName = editLast.getText().toString().trim();

        try{
            Log.d(TAG, "before user");
            //Encapsulate Data
            final User user = new User(
                    firstName,
                    lastName,
                    ((Switch) findViewById(R.id.adminSwitch)).isChecked()
            );

            final Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(INTENT_USER_KEY, user);
            startActivity(intent);

        } catch (InvalidNameException e) {
            Log.d(TAG, "inside catch");
            if (e.getName().equals(firstName)) {
                Log.d(TAG, "in catch first name if");
                editFirst.requestFocus();
                editFirst.setError("Please Enter a Name");
            } else if (e.getName().equals(lastName)){
                editLast.requestFocus();
                editLast.setError("Please Enter a Name");
            }
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