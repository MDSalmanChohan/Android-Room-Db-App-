package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drawernavigation.Adapter.Product_Adapter;
import com.example.drawernavigation.ModelClass.food_model;

import java.util.ArrayList;


public class Product_Fragment extends Fragment {

    RecyclerView productRecycler;
    Product_Adapter adapter;
    ArrayList<food_model> model = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_product_, container, false);

       productRecycler = view.findViewById(R.id.productRecycler);

      productRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));

        model.add(new food_model("Sandwich","Rs.50",R.drawable.sandwich));
        model.add(new food_model("Pasta","Rs.30",R.drawable.pasta));
        model.add(new food_model("Biryani","Rs.60",R.drawable.biryani));
        model.add(new food_model("Biryani","Rs.80",R.drawable.chicken));
        model.add(new food_model("LadyFinger","Rs.30kg",R.drawable.ladyfinger));
        model.add(new food_model("Corrinder","Rs.120kg",R.drawable.corindor));
        model.add(new food_model("Brinal","Rs.20kg",R.drawable.brinjal));
        model.add(new food_model("Pumpkin","Rs.40kg",R.drawable.pumpkin));
        model.add(new food_model("Cravings","Rs.60",R.drawable.cravings));
        model.add(new food_model("Birger","Rs.70",R.drawable.burger));
        model.add(new food_model("Apple", "$4.5", R.drawable.apple));
        model.add(new food_model("Orange", "$43.5", R.drawable.orangee));
        model.add(new food_model("Potato","Rs.20kg",R.drawable.potato));
        model.add(new food_model("Tomato","Rs.60kg",R.drawable.tomato));
        model.add(new food_model("Onion","Rs.40kg",R.drawable.onion));
        model.add(new food_model("Pizza","Rs.250",R.drawable.pizza));
        model.add(new food_model("Grapes", "$4.5",R.drawable.grapes));
        model.add(new food_model("Banana", "$43.5",R.drawable.banana));
        model.add(new food_model("Papaya", "$4.5",R.drawable.papaya));
        model.add(new food_model("Litchi", "$43.5",R.drawable.litchi));
        model.add(new food_model("Sandwich","Rs.50",R.drawable.sandwich));
        model.add(new food_model("Pasta","Rs.30",R.drawable.pasta));
        model.add(new food_model("Biryani","Rs.60",R.drawable.biryani));
        model.add(new food_model("Biryani","Rs.80",R.drawable.chicken));
        model.add(new food_model("LadyFinger","Rs.30kg",R.drawable.ladyfinger));
        model.add(new food_model("Corrinder","Rs.120kg",R.drawable.corindor));
        model.add(new food_model("Brinal","Rs.20kg",R.drawable.brinjal));
        model.add(new food_model("Pumpkin","Rs.40kg",R.drawable.pumpkin));
        model.add(new food_model("Cravings","Rs.60",R.drawable.cravings));
        model.add(new food_model("Birger","Rs.70",R.drawable.burger));
        model.add(new food_model("Apple", "$4.5", R.drawable.apple));
        model.add(new food_model("Orange", "$43.5", R.drawable.orangee));
        model.add(new food_model("Potato","Rs.20kg",R.drawable.potato));
        model.add(new food_model("Tomato","Rs.60kg",R.drawable.tomato));
        model.add(new food_model("Onion","Rs.40kg",R.drawable.onion));
        model.add(new food_model("Pizza","Rs.250",R.drawable.pizza));
        model.add(new food_model("Grapes", "$4.5",R.drawable.grapes));
        model.add(new food_model("Banana", "$43.5",R.drawable.banana));
        model.add(new food_model("Papaya", "$4.5",R.drawable.papaya));
        model.add(new food_model("Litchi", "$43.5",R.drawable.litchi));

        adapter = new Product_Adapter(getContext(),model);
        productRecycler.setAdapter(adapter);



        return view;
    }
}