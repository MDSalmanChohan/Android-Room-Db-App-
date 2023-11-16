package com.example.drawernavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetail extends AppCompatActivity {

    ImageView heart,image;
    TextView name,price;
    boolean like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        heart = findViewById(R.id.heart);
        image = findViewById(R.id.image);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like)
                {
                    like = false;
                    heart.setImageResource(R.drawable.love);
                }
                else
                {
                    like = true;
                    heart.setImageResource(R.drawable.heart);
                }
            }
        });

        Intent intent = getIntent();
        image.setImageResource(getIntent().getIntExtra("image",0));
        name.setText(getIntent().getStringExtra("name"));
        price.setText(getIntent().getStringExtra("price"));
    }
}