package com.example.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.AdaptorRecycle;
import com.example.myapplication.DBHandler;
import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.Iterator;
import java.util.List;

public class AdminPage extends AppCompatActivity {

    private String[] array ={"Neetu","Pooja","jitendra","sahebrao kadu","Ratna kadu"};
    private ListView mListView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

//        mListView = findViewById(R.id.listview_user);
        recyclerView = findViewById(R.id.recycleview_acti);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,array);
//        mListView.setAdapter(arrayAdapter);
        DBHandler handle = new DBHandler(AdminPage.this);
        List<User> user = handle.getAllUser();
//        UserBaseAdaptor baseAdaptor = new UserBaseAdaptor(this, user);
//        mListView.setAdapter(baseAdaptor);

        AdaptorRecycle adaptorRecycle = new AdaptorRecycle(user);
        recyclerView.setAdapter(adaptorRecycle);




    }
}