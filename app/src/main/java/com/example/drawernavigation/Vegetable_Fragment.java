package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drawernavigation.Adapter.vegetable_Adapter;
import com.example.drawernavigation.ModelClass.vegetable_model;

import java.util.ArrayList;


public class Vegetable_Fragment extends Fragment {

  RecyclerView vegetable_recycler;
  vegetable_Adapter vegetable_adapter;
  ArrayList<vegetable_model> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vegetable_, container, false);

        vegetable_recycler = view.findViewById(R.id.vegetable_recycler);
        vegetable_recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();
        vegetable_model ob1 = new vegetable_model("Potato","Rs.20kg",R.drawable.potato);
        arrayList.add(ob1);
        vegetable_model ob2 = new vegetable_model("Tomato","Rs.60kg",R.drawable.tomato);
        arrayList.add(ob2);
        vegetable_model ob3 = new vegetable_model("Onion","Rs.40kg",R.drawable.onion);
        arrayList.add(ob3);
        vegetable_model ob4 = new vegetable_model("LadyFinger","Rs.30kg",R.drawable.ladyfinger);
        arrayList.add(ob4);
        vegetable_model ob5 = new vegetable_model("Corrinder","Rs.120kg",R.drawable.corindor);
        arrayList.add(ob5);
        vegetable_model ob6 = new vegetable_model("Brinal","Rs.20kg",R.drawable.brinjal);
        arrayList.add(ob6);
        vegetable_model ob7 = new vegetable_model("Pumpkin","Rs.40kg",R.drawable.pumpkin);
        arrayList.add(ob7);
        vegetable_model ob11 = new vegetable_model("Potato","Rs.20kg",R.drawable.potato);
        arrayList.add(ob11);
        vegetable_model ob12 = new vegetable_model("Tomato","Rs.60kg",R.drawable.tomato);
        arrayList.add(ob12);
        vegetable_model ob13 = new vegetable_model("Onion","Rs.40kg",R.drawable.onion);
        arrayList.add(ob13);
        vegetable_model ob14 = new vegetable_model("LadyFinger","Rs.30kg",R.drawable.ladyfinger);
        arrayList.add(ob14);
        vegetable_model ob15 = new vegetable_model("Corrinder","Rs.120kg",R.drawable.corindor);
        arrayList.add(ob15);
        vegetable_model ob16 = new vegetable_model("Brinal","Rs.20kg",R.drawable.brinjal);
        arrayList.add(ob16);
        vegetable_model ob17 = new vegetable_model("Pumpkin","Rs.40kg",R.drawable.pumpkin);
        arrayList.add(ob17);

        vegetable_adapter = new vegetable_Adapter(getContext(),arrayList);
        vegetable_recycler.setAdapter(vegetable_adapter);


        return view;
    }
}