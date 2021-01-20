package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;


import android.widget.CompoundButton;
import android.widget.Switch;
import static android.content.res.Configuration.UI_MODE_NIGHT_YES;
import android.widget.Toast;


public class Settings extends AppCompatActivity {
    public SwitchCompat myswitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        myswitch=(SwitchCompat)findViewById(R.id.switch2);
        if (currentNightMode == UI_MODE_NIGHT_YES) {
            myswitch.setChecked(true);
        }
        myswitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();

            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
        });


    }

    @Override
    protected void onStart() {

        super.onStart();

    }

    @Override
    protected void onResume() {

        super.onResume();

        SharedPreferences prefs = getSharedPreferences("test", Context.MODE_PRIVATE);
        int myVariable = prefs.getInt("myVariable", 1);



    }


    @Override
    protected void onPause() {

        super.onPause();

        myswitch=(SwitchCompat)findViewById(R.id.switch2);
        SharedPreferences.Editor ed = getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        ed.putBoolean("switchState", myswitch.isChecked());
        ed.apply();


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