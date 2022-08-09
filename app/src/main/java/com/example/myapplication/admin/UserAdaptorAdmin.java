package com.example.myapplication.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserAdaptorAdmin extends ArrayAdapter<User> {

    public UserAdaptorAdmin(@NonNull Context context, ArrayList<User> userList) {
        super(context,0, userList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     View currentItemView = convertView;
     if (currentItemView == null){
         currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custome_listview_db,parent,false);
     }
        User currentUser = getItem(position);

//        ImageView imageview = currentItemView.findViewById(R.id.image_view_user_photo);
        TextView textViewFirstName = currentItemView.findViewById(R.id.text_view_firstname);
        TextView textviewLastName = currentItemView.findViewById(R.id.text_view_lastname);
        TextView textViewEmial = currentItemView.findViewById(R.id.text_view_email);



        return super.getView(position, convertView, parent);
    }
}
