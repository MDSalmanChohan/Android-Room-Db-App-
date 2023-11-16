package com.example.drawernavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VegetableDetail extends AppCompatActivity {

    ImageView heart,image;
    TextView name,price;
    boolean like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_detail);

        heart = findViewById(R.id.heart);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);


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

        image.setImageResource(getIntent().getIntExtra("image",0));
        name.setText(getIntent().getStringExtra("name"));
        price.setText(getIntent().getStringExtra("price"));
    }
}