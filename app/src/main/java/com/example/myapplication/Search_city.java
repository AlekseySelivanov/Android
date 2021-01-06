package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Search_city extends AppCompatActivity {
    public ListView lv;

    //ListView Адаптер:
    ArrayAdapter<String> adapter;

    //Поиск EditText
    EditText inputSearch;

    //Строковый массив
    ArrayList<HashMap<String, String>> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
        String words[] = {"Москва", "Санкт-Петербург", "Екатеринбург", "Рязань", "Мурманск",
                "Якутск"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        //Связываем данные массива с элементом ListView:
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, words);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                //Когда пользователь вводит какой-нибудь текст:
                Search_city.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
    }
}