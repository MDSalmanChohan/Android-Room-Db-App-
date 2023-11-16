package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drawernavigation.Adapter.Food_Adapter;
import com.example.drawernavigation.ModelClass.food_model;

import java.util.ArrayList;


public class Food_Fragment extends Fragment {
        RecyclerView food_recycler;
        Food_Adapter food_adapter;
        ArrayList<food_model> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_food_, container, false);

       food_recycler  = view.findViewById(R.id.food_recycler);
       food_recycler.setLayoutManager(new LinearLayoutManager(getContext()));

       arrayList = new ArrayList<>();
       food_model ob1 = new food_model("Sandwich","Rs.50",R.drawable.sandwich);
        arrayList.add(ob1);
        food_model ob2 = new food_model("Pasta","Rs.30",R.drawable.pasta);
        arrayList.add(ob2);
        food_model ob4 = new food_model("Biryani","Rs.60",R.drawable.biryani);
        arrayList.add(ob4);
        food_model ob5 = new food_model("Biryani","Rs.80",R.drawable.chicken);
        arrayList.add(ob5);
        food_model ob6 = new food_model("Cravings","Rs.60",R.drawable.cravings);
        arrayList.add(ob6);
        food_model ob7 = new food_model("Birger","Rs.70",R.drawable.burger);
        arrayList.add(ob7);
        food_model ob8 = new food_model("Pizza","Rs.250",R.drawable.pizza);
        arrayList.add(ob8);
        food_model ob9 = new food_model("Sandwich","Rs.50",R.drawable.sandwich);
        arrayList.add(ob9);
        food_model ob21 = new food_model("Pasta","Rs.30",R.drawable.pasta);
        arrayList.add(ob21);
        food_model ob14 = new food_model("Biryani","Rs.60",R.drawable.biryani);
        arrayList.add(ob14);
        food_model ob15 = new food_model("Biryani","Rs.80",R.drawable.chicken);
        arrayList.add(ob15);
        food_model ob16 = new food_model("Cravings","Rs.60",R.drawable.cravings);
        arrayList.add(ob16);
        food_model ob17 = new food_model("Birger","Rs.70",R.drawable.burger);
        arrayList.add(ob17);
        food_model ob18 = new food_model("Pizza","Rs.250",R.drawable.pizza);
        arrayList.add(ob18);

        food_adapter = new Food_Adapter(getContext(),arrayList);
        food_recycler.setAdapter(food_adapter);
       return view;
    }
}