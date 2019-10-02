package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "DisplayActivity";

    Switch adminSwitch;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<String> list ;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Use Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.rvUsers);
        //Fix Size of View
        recyclerView.setHasFixedSize(true);
        //Make Linear
        layoutManager = new LinearLayoutManager(this);

        Log.d(TAG, "before array");

        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("WHAT THE FUXCKKK");
        }

        //Specify Adapter
        adapter = new UserAdapter(this, list, new AdapterClickListener() {
            @Override
            public void onItemClicked(int pos) {

            }
        }, new AdapterDeleteListen() {
            @Override
            public void itemDeleted(int pos) {
                list.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(adapter);

        // Get the Intent that started this activity and extract the string
        /*
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
        */
    }
}
