package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddCityFragment.OnFragmentInteractionListener {

    private ArrayList<City> dataList;
    private ListView cityList;
    private ArrayAdapter<City> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        String[] cities = {
                "Edmonton", "Vancouver"
        };

        String[] provinces = {
                "AB", "BC"
        };
        for (int i = 0; i < cities.length; i++) {
            City city = new City(cities[i], provinces[i]);
            dataList.add(city);
        }
        cityAdapter = new CustomList(this, dataList);
        cityList = findViewById(R.id.city_list);
        cityList.setAdapter(cityAdapter);

        final FloatingActionButton addButton = findViewById(R.id.add_city_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddCityFragment().show(getSupportFragmentManager(), "ADD_CITY");
            }
        });
    }

    @Override
    public void onOKPressed(City city) {
        dataList.add(city);
        cityAdapter.notifyDataSetChanged();
    }
}
