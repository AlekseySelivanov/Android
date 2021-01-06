package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button4;
    Button button;
    String LOG = "log";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG, "onCreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        Log.d(LOG, "onStart");
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        Log.d(LOG, "onResume");
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        Log.d(LOG, "onPause");
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        Log.d(LOG, "onStop");
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        Log.d(LOG, "onRestart");
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        Log.d(LOG, "onDestroy");
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
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
            default:
                break;
        }
    }

}
