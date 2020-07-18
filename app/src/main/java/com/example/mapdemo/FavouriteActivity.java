package com.example.mapdemo;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapdemo.Model.Favourite;
import com.example.mapdemo.util.SQLHelperClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    SQLHelperClass myDB;
    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private List<Favourite> FavouriteArrayList = new ArrayList<>();
    ArrayList<String> location_id, location_latitude, location_longitude, location_city, location_state, location_pincode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        myDB = new SQLHelperClass(FavouriteActivity.this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        SQLHelperClass sqlHelperClass = new SQLHelperClass(this);
        location_id = new ArrayList<>();
        location_latitude = new ArrayList<>();
        location_longitude = new ArrayList<>();
        location_city = new ArrayList<>();
        location_state = new ArrayList<>();
        location_pincode=new ArrayList<>();
        storeDataInArrays();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(FavouriteActivity.this));
        favouriteAdapter = new FavouriteAdapter(FavouriteActivity.this,this, location_id, location_latitude, location_longitude,
                location_city,location_state,location_pincode);
        recyclerView.setAdapter(favouriteAdapter);
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllLocation();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){
                location_id.add(cursor.getString(0));
                location_latitude.add(cursor.getString(1));
                location_longitude.add(cursor.getString(2));
                location_city.add(cursor.getString(3));
                location_state.add(cursor.getString(4));
                location_pincode.add(cursor.getString(5));
            }

        }
    }


}
