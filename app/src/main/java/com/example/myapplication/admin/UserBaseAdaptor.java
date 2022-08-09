package com.example.myapplication.admin;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import org.w3c.dom.Text;

import java.util.List;


public class UserBaseAdaptor extends BaseAdapter {

    private Context mContext;
    private List<User> mUserList;

    public UserBaseAdaptor(Context context, List<User> user) {
        this.mContext = context;
        this.mUserList = user;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public String getItem(int currentPosition) {
        return mUserList.get(currentPosition).getLastName();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        User userObje = mUserList.get(position);   //GET THE POSITION AND SET THE VIEW FROM USER_OBJECT

            LayoutInflater mInfaltor = LayoutInflater.from(mContext);
            view = mInfaltor.inflate(R.layout.custome_listview_db,null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        TextView firstName = view.findViewById(R.id.text_view_firstname);
        TextView lastName = view.findViewById(R.id.text_view_lastname);
        TextView email = view.findViewById(R.id.text_view_email);
        Button buttonViewDetail = view.findViewById(R.id.button_view_details);
        firstName.setText(userObje.getFirstName());
        lastName.setText(userObje.getLastName());
        email.setText(userObje.getEmail());

        buttonViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"user :"+ getItem(position),Toast.LENGTH_SHORT ).show();
            }
        });
        return view;
    }


}
