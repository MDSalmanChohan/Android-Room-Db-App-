package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drawernavigation.Adapter.fruit_adapter;
import com.example.drawernavigation.ModelClass.Model;

import java.util.ArrayList;

public class Fruit_Fragment extends Fragment {
    RecyclerView fruit_recycler;
    fruit_adapter fruitAdapter;
    ArrayList<Model> fruit_list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit_, container, false);

        fruit_recycler = view.findViewById(R.id.fruit_recycler);
        fruit_recycler.setLayoutManager(new LinearLayoutManager(getContext()));


        fruit_list = new ArrayList<>();
        Model ob1 = new Model( "Grapes\n", "$4.5",R.drawable.grapes);
        fruit_list.add(ob1);
        Model ob2 = new Model( "Banana\n", "$43.5",R.drawable.banana);
        fruit_list.add(ob2);
        Model ob3 = new Model( "Papaya\n", "$4.5",R.drawable.papaya);
        fruit_list.add(ob3);
        Model ob4 = new Model( "Litchi\n", "$43.5",R.drawable.litchi);
        fruit_list.add(ob4);
        Model ob5 = new Model("Apple\n", "$4.5", R.drawable.apple);
        fruit_list.add(ob5);
        Model ob6 = new Model("Orange\n", "$43.5", R.drawable.orangee);
        fruit_list.add(ob6);
        Model ob11 = new Model( "Grapes\n", "$4.5",R.drawable.grapes);
        fruit_list.add(ob11);
        Model ob12 = new Model( "Banana\n", "$43.5",R.drawable.banana);
        fruit_list.add(ob12);
        Model ob13 = new Model( "Papaya\n", "$4.5",R.drawable.papaya);
        fruit_list.add(ob13);
        Model ob14 = new Model( "Litchi\n", "$43.5",R.drawable.litchi);
        fruit_list.add(ob14);
        Model ob15 = new Model("Apple\n", "$4.5", R.drawable.apple);
        fruit_list.add(ob15);
        Model ob16 = new Model("Orange\n", "$43.5", R.drawable.orangee);
        fruit_list.add(ob16);

        fruitAdapter = new fruit_adapter(getContext(), fruit_list);
        fruit_recycler.setAdapter(fruitAdapter);

        return view;
    }
}