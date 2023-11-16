package com.example.drawernavigation.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.drawernavigation.FavDatabase;
import com.example.drawernavigation.ModelClass.WislistItem;
import com.example.drawernavigation.R;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    ArrayList<WislistItem> arrayList;
    Context context;
    boolean like;

    public FavAdapter(ArrayList<WislistItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.apple.setImageResource(Integer.parseInt(String.valueOf(arrayList.get(position).getImage())));
        holder.name.setText(arrayList.get(position).getName());
        holder.price.setText(arrayList.get(position).getPrice());

        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setMessage("Do you really want to delete this item list from wishlist");
//                    builder.setTitle("Alert !");
//                    builder.setCancelable(false);
//                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            FavDatabase favDatabase = FavDatabase.getInstance(context);
//                            MyInterface dao = favDatabase.getDao();
                            FavDatabase favDatabase = Room.databaseBuilder(context,FavDatabase.class,"Favdb")
                                    .allowMainThreadQueries().build();
                            MyInterface dao = favDatabase.getDao();
                            // delete in roomdatabase
                            dao.deleteRecord(String.valueOf(arrayList.get(position).getImage()));
                            // delete in recycler
                            arrayList.remove(position);
                            // after delete refresh record
                            notifyDataSetChanged();
//                        }
//                    });
//                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        try {
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView apple, heart;
        TextView name, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            apple = (itemView).findViewById(R.id.apple);
            name = (itemView).findViewById(R.id.name);
            price = (itemView).findViewById(R.id.price);
            heart = itemView.findViewById(R.id.heart);
        }
    }
}
