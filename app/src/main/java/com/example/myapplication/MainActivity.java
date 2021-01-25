package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, IRVOnItemClick {
    Button button4;
    Button button;
    String LOG = "log";
    private RecyclerView recyclerView;
    private RecyclerDataAdapter adapter;

private ArrayList<String> listData = new ArrayList<>(Arrays.asList("Понедельник 15С", "Вторник 15С","Среда 15С","Четверг 15С","Пятница 15С","Суббота 15С","Воскресенье 15С"));






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

        initViews();
        setupRecyclerView();
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
    }
    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getBaseContext());
        adapter = new RecyclerDataAdapter(listData, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onItemClicked(String itemText) {
        Toast.makeText(getBaseContext(), itemText, Toast.LENGTH_SHORT).show();
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
