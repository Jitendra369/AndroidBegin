package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.User;

import java.util.List;

public class AdaptorRecycle extends RecyclerView.Adapter<AdaptorRecycle.Holder> {
    List<User> user;
    public AdaptorRecycle(List<User> user){
        this.user = user;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_listview_db,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User userObej = user.get(position);
        holder.fistname.setText(userObej.getFirstName());
        holder.lastname.setText(userObej.getLastName());
        holder.emial.setText(userObej.getEmail());
    }


    @Override
    public int getItemCount() {

        return user.size();
    }

    class Holder extends RecyclerView.ViewHolder{
//        ImageView imageView;
        TextView fistname;
        TextView lastname;
        TextView emial;
        Button buttomDetails;
        public Holder(@NonNull View itemView) {
            super(itemView);
//            imageView = itemView.findViewById(R.id.image_view_user_photo);
            fistname = itemView.findViewById(R.id.text_view_firstname);
            lastname = itemView.findViewById(R.id.text_view_lastname);
            emial = itemView.findViewById(R.id.text_view_email);
            buttomDetails = itemView.findViewById(R.id.button_view_details);

        }
    }
}
