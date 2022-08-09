package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication.model.User;

import java.util.List;

public class SecondActi extends AppCompatActivity {

    private ListView mListView;
    String[] userName;
    private List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mListView = findViewById(R.id.listview);
        DBHandler handler = new DBHandler(SecondActi.this);
        user = handler.getAllUser();
        for (User users: user){
            Log.d("db", "fName: "+ users.getFirstName()+" LName : "+users.getLastName());
        }


    }
}