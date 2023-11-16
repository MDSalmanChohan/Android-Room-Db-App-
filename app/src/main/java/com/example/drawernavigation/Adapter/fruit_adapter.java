package com.example.drawernavigation.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawernavigation.FavDatabase;
import com.example.drawernavigation.FavoriteList;
import com.example.drawernavigation.FruitDetail;
import com.example.drawernavigation.ModelClass.Model;
import com.example.drawernavigation.ModelClass.WislistItem;
import com.example.drawernavigation.R;

import java.util.ArrayList;
import java.util.List;

public class fruit_adapter extends RecyclerView.Adapter<fruit_adapter.myViewHolder> {
    Context context;
    ArrayList<Model> fruit_list;
    boolean like;
    int i;

    public fruit_adapter(Context context, ArrayList<Model> fruit_list) {
        this.context = context;
        this.fruit_list = fruit_list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_design, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        FavDatabase dbHelper = FavDatabase.getInstance(context);
        holder.apple.setImageResource(fruit_list.get(position).getImage());
        holder.name.setText(fruit_list.get(position).getName());
        holder.price.setText(fruit_list.get(position).getPrice());
        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (like) {
                    if (i == 0)


                        like = false;
                    holder.heart.setImageResource(R.drawable.love);
                } else {

                    //if (i == 1)

                    like = true;
                    holder.heart.setImageResource(R.drawable.heart);

                    /*2131165398  Papaya $4.5 */
                    List<WislistItem> wislistItem1 = dbHelper.getDao().getFavoriteList1(String.valueOf(fruit_list.get(position).getImage()));
                    if (wislistItem1.size()>0) {
//                        Toast.makeText(context, "Already Exist", Toast.LENGTH_SHORT).show();

                        dbHelper.getDao().deleteRecord(String.valueOf(fruit_list.get(position).getImage()));
                        Toast.makeText(context, "Removed from Wishlist", Toast.LENGTH_SHORT).show();
                    } else {
                        dbHelper.getDao().addData(
                                new WislistItem(fruit_list.get(position).getImage(), fruit_list.get(position).getName(), fruit_list.get(position).getPrice())

                        );
                        Toast.makeText(context, "Added in Wishlist", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return fruit_list.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView apple, heart;
        TextView name, price;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            apple = (itemView).findViewById(R.id.apple);
            name = (itemView).findViewById(R.id.name);
            price = (itemView).findViewById(R.id.price);
            heart = itemView.findViewById(R.id.heart);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Intent intent = new Intent(context, FruitDetail.class);
            intent.putExtra("image", fruit_list.get(position).getImage());
            intent.putExtra("name", fruit_list.get(position).getName());
            intent.putExtra("price", fruit_list.get(position).getPrice());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
