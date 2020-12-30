package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;


import android.widget.Switch;

import android.widget.Toast;


public class Settings extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        Switch switch2 = findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);


            }else{
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onPause() {

        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {

        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }


}