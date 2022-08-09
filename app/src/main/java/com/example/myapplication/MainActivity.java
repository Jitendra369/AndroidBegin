package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.admin.AdminPage;
import com.example.myapplication.model.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private Button mButtonViewDb;
    private static final int REQUEST_CODE=2;
    private ListView mListViewNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //binding the layout to java
        mEditTextUsername = findViewById(R.id.editetextUsername);
        mEditTextPassword = findViewById(R.id.editetextUserpass);
        mButtonLogin = findViewById(R.id.button_login);
        mButtonViewDb = findViewById(R.id.button_view_db);
        mListViewNames = findViewById(R.id.listview_names);

        mButtonLogin.setOnClickListener(this);
        mButtonViewDb.setOnClickListener(this);

}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null){
            if (requestCode==2){
                Toast.makeText(getApplicationContext(),data.getStringExtra("message"),Toast.LENGTH_SHORT).show();
            }
        }else {
            Log.d("return","Nothing has return");
        }

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int id1 = R.id.button_login;
        switch (id) {
            case R.id.button_login:
                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_EMAIL,"fucker");
//                startActivity(intent);
//                Intent intent = new Intent(getApplicationContext(), SecondActi.class);
//                startActivityForResult(intent,MainActivity.REQUEST_CODE);

                Intent intentAd = new Intent(getApplicationContext(), AdminPage.class);
                startActivity(intentAd);
//                String username = mEditTextUsername.getText().toString();
//                String password = mEditTextPassword.getText().toString();
//                if(username.equals("A") && password.equals("B")){
//                    Intent intentAd = new Intent(getApplicationContext(), AdminPage.class);
//                    startActivity(intentAd);
//                }else{
//                    Intent newIntent = new Intent(getApplicationContext(), SignUp.class);
//                    startActivity(newIntent);
//                }



                break;
            case R.id.button_view_db:

                DBHandler handler = new DBHandler(MainActivity.this);
                List<User> user;
                user = handler.getAllUser();
                String listName[] = new String[user.size()];
                int counter =0;
                for (User users: user){
//                    Log.d("db", "fName: "+ users.getFirstName()+" LName : "+users.getLastName());
                    listName[counter++] = users.getFirstName();
                }
                ArrayAdapter<String> adaptor = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listName );
                mListViewNames.setAdapter(adaptor);

                LayoutInflater inflator = getLayoutInflater();
                View layout_toast = inflator.inflate(R.layout.custom_toast,findViewById(R.id.custome_layout));
                Toast tost = new Toast(getApplicationContext());
                TextView textViewTitle = layout_toast.findViewById(R.id.title_message);
                TextView textViewMessage = layout_toast.findViewById(R.id.message_message);
                textViewTitle.setText("Android Cource Fees");
                textViewMessage.setText("Rs 4000/- only");

                tost.setDuration(Toast.LENGTH_SHORT);
                tost.setGravity(Gravity.CENTER_VERTICAL,0,0);


                tost.setView(layout_toast);
//                tost.makeText()
                tost.show();




                break;
            default:
                Toast.makeText(getApplicationContext(),"not handle click ", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    //    todo: what is the use on insave instance state
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        ArrayList<String> userCre = new ArrayList<>();
        userCre.add(mEditTextUsername.getText().toString().trim());
        userCre.add(mEditTextPassword.getText().toString().trim());
        outState.putStringArrayList("userCre",userCre);
        Log.e("TAG","onSaveInstaance State");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.e("TAG","onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.e("TAG","onPostCreate");
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"resume the app", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("TAG","onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG","onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.e("TAG","onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.e("TAG","onStart()");
        super.onStart();
    }


}