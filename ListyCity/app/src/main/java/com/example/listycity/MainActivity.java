package com.example.listycity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AddCityFragment.OnFragmentInteractionListener {

    private ArrayList<City> dataList;
    private ListView cityList;
    private ArrayAdapter<City> cityAdapter;
    private FirebaseFirestore db;
    private CollectionReference citiesRef;
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        citiesRef = db.collection("cities");

        dataList = new ArrayList<>();

        cityAdapter = new CustomList(this, dataList);
        cityList = findViewById(R.id.city_list);
        cityList.setAdapter(cityAdapter);

        final FloatingActionButton addButton = findViewById(R.id.add_city_button);
        final FloatingActionButton deleteButton = findViewById(R.id.delete_city_button);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    citiesRef.document(dataList.get(selectedPosition).getName())
                            .delete();
                    cityList.clearChoices();
                    selectedPosition = -1;
                }
                catch(Exception e) {
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddCityFragment().show(getSupportFragmentManager(), "ADD_CITY");
            }
        });

        citiesRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent( QuerySnapshot querySnapshots,
                                 FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("Firestore", error.toString());
                    return;
                }
                if (querySnapshots != null) {
                    dataList.clear();
                    for (QueryDocumentSnapshot doc: querySnapshots) {
                        String city = doc.getId();
                        String province = doc.getString("Province");
                        Log.d("Firestore", String.format("City(%s, %s) fetched",
                                city, province));
                        dataList.add(new City(city, province));
                    }
                    cityAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onOKPressed(City city) {
        HashMap<String, String> data = new HashMap<>();
        data.put("Province", city.getProvince());
        citiesRef
                .document(city.getName())
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Firestore", "DocumentSnapshot successfully written!");
                    }
                });


    }
}
