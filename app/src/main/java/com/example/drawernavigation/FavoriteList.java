package com.example.drawernavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.drawernavigation.Adapter.FavAdapter;
import com.example.drawernavigation.Adapter.MyInterface;
import com.example.drawernavigation.ModelClass.WislistItem;

import java.util.ArrayList;

public class FavoriteList extends AppCompatActivity {

    RecyclerView recyclerView;
    FavAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        recyclerView = findViewById(R.id.recycler);

        FavDatabase dbHelper = Room.databaseBuilder(getApplicationContext(),FavDatabase.class,"Favdb")
                .allowMainThreadQueries().build();
        MyInterface dao = dbHelper.getDao();



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<WislistItem>  model =(ArrayList<WislistItem>) dao.getFavoriteList();
        adapter = new FavAdapter(model,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}