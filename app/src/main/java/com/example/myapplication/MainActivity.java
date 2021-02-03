package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.android.material.snackbar.Snackbar;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, IRVOnItemClick {
    Button button4;
    Button button;
    String LOG = "log";
    private RecyclerView recyclerView;
    private RecyclerDataAdapter adapter;
//    readSettings();
//    initView();



    private ArrayList<String> listData = new ArrayList<>(Arrays.asList("Понедельник 15С", "Вторник 15С","Среда 15С","Четверг 15С","Пятница 15С","Суббота 15С","Воскресенье 15С"));






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG, "onCreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        String value= getIntent().getStringExtra("getData");
        ((TextView)findViewById(R.id.textView7)).setText(value);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        initViews();
        setupRecyclerView();
    }

    private void initView() {
        initToolbar();
//        initButtonMain();
//        initButtonFavorite();
//        initButtonSettings();
//        initButtonBack();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Обработка выбора пункта меню приложения (активити)
//        int id = item.getItemId();
//
//        switch(id){
//            case R.id.action_settings:
//                addFragment(new SettingsFragment());
//                return true;
//            case R.id.action_main:
//                addFragment(new MainFragment());
//                return true;
//            case R.id.action_favorite:
//                addFragment(new FavoriteFragment());
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Здесь определяем меню приложения (активити)
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem search = menu.findItem(R.id.action_search); // поиск пункта меню поиска
        SearchView searchText = (SearchView) search.getActionView(); // строка поиска
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // реагирует на конец ввода поиска
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }
            // реагирует на нажатие каждой клавиши
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return true;
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
                Snackbar.make(v, "Выберите город!", Snackbar.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(this, Search_city.class);
                startActivity(intent);
                break;
            case R.id.button:
                Snackbar.make(v, "Настройки!", Snackbar.LENGTH_LONG)
                        .show();
                Intent intent1 = new Intent(this, Settings.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
