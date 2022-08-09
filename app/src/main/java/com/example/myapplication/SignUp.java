package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.User;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    private EditText mEditTextFirstName;
    private EditText mEditTextpassword;
    private EditText mEditTextEmail;
    private EditText mEditTextLastName;
    private EditText mEditTextConformPass;
    private Button mButtonSignUp;
    private MaterialCheckBox materialCheckBox;
    private ArrayList<String> userDetails;
    private String firstName;
    private String lastName;
    private String emial;
    private String password;
    private DBHandler dbHandler;
    private User user;

    com.example.myapplication.databinding.ActivitySuperUserBinding mxl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEditTextFirstName = findViewById(R.id.editetext_fristname);
        mEditTextLastName = findViewById(R.id.editext_lastname);
        mEditTextEmail = findViewById(R.id.editext_emailaddress);
        mEditTextpassword = findViewById(R.id.editetext_password);
        mButtonSignUp = findViewById(R.id.button_signup);
        mEditTextConformPass = findViewById(R.id.editetext_conformpassword);
        materialCheckBox = findViewById(R.id.checkbox_termsandCondition);

//        todo: confrom password validation
//        todo: checkbox validation
//        userDetails = new ArrayList<>();
//        userDetails.add(mEditTextFirstName.getText().toString().trim());
//        userDetails.add(lastName);
//        userDetails.add(emial);
//        userDetails.add(password);



        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstName = mEditTextFirstName.getText().toString();
                lastName = mEditTextLastName.getText().toString();
                emial = mEditTextEmail.getText().toString();
                password = mEditTextpassword.getText().toString();

                if (firstName != "" & lastName != "" & emial != "" & password != ""){

                user = new User(firstName,lastName,password,emial);
                        dbHandler = new DBHandler(SignUp.this);
                        dbHandler.addUserSignUpPage(user);
                    }
                Toast.makeText(getApplicationContext(),"data added", Toast.LENGTH_SHORT).show();
                mEditTextFirstName.setText("");
                mEditTextLastName.setText("");
                mEditTextEmail.setText("");
                mEditTextpassword.setText("");
                mEditTextConformPass.setText("");
                }

        });

    }
}

