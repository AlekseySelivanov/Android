package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button4;
    Button button;
    Button button3;
    String LOG = "log";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG, "onCreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String value= getIntent().getStringExtra("getData");
        ((TextView)findViewById(R.id.textView7)).setText(value);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);



    }



    @Override
    protected void onStart() {
        Log.d(LOG, "onStart");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d(LOG, "onResume");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.d(LOG, "onPause");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.d(LOG, "onStop");
        super.onStop();


    }

    @Override
    protected void onRestart() {
        Log.d(LOG, "onRestart");
        super.onRestart();


    }

    @Override
    protected void onDestroy() {
        Log.d(LOG, "onDestroy");
        super.onDestroy();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Intent intent = new Intent(this, Search_city.class);
                startActivity(intent);
                break;
            case R.id.button:
                Intent intent1 = new Intent(this, Settings.class);
                startActivity(intent1);
                break;
            case R.id.button3:
                Fragment frag = new FragmentEmblem();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_frame,frag,"Test Fragment");
                transaction.addToBackStack(null);
                transaction.commit();
            default:
                break;
        }
    }
}
