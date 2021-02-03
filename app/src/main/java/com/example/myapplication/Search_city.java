package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Search_city extends AppCompatActivity {
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
       AutoCompleteTextView textViewSend = (AutoCompleteTextView) findViewById(R.id.textViewSend);


        String[] countries = getResources().getStringArray(R.array.city_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textViewSend.setAdapter(adapter);
        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);

        });
    }
}