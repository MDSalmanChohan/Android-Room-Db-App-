package com.example.drawernavigation.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawernavigation.FavDatabase;
import com.example.drawernavigation.ModelClass.WislistItem;
import com.example.drawernavigation.ModelClass.vegetable_model;
import com.example.drawernavigation.R;
import com.example.drawernavigation.VegetableDetail;

import java.util.ArrayList;
import java.util.List;

public class vegetable_Adapter extends RecyclerView.Adapter<vegetable_Adapter.myViewHolder> {

    Context context;
    ArrayList<vegetable_model> arrayList;
    boolean like;
    public vegetable_Adapter(Context context, ArrayList<vegetable_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(context).inflate(R.layout.vegetable_design,parent,false);
    return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        FavDatabase dbHelper = FavDatabase.getInstance(context);
        holder.iv_pic.setImageResource(arrayList.get(position).getImage());
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_price.setText(arrayList.get(position).getPrice());
//        holder.heart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//                alertDialog.setMessage("Do you want to like this item ");
//                alertDialog.setTitle("Alert !");
//                alertDialog.setCancelable(false);
//                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (like){
//                            like = false;
//                            holder.heart.setImageResource(R.drawable.love);
//                        }
//                        else
//                        {
//                            like = true;
//                            holder.heart.setImageResource(R.drawable.heart);
//                        }
//
//                    }
//                });
//                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        dialog.cancel();
//                    }
//                });
//                AlertDialog Dialog = alertDialog.create();
//                // Show the Alert Dialog box
//                Dialog.show();
//            }
//        });
        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (like) {
                    like = false;
                    holder.heart.setImageResource(R.drawable.love);
                } else {

                    //if (i == 1)

                    like = true;
                    holder.heart.setImageResource(R.drawable.heart);

                    /*2131165398  Papaya $4.5 */
                    List<WislistItem> wislistItem1 = dbHelper.getDao().getFavoriteList1(String.valueOf(arrayList.get(position).getImage()));
                    if (wislistItem1.size()>0) {
//                        Toast.makeText(context, "Already Exist", Toast.LENGTH_SHORT).show();

                        dbHelper.getDao().deleteRecord(String.valueOf(arrayList.get(position).getImage()));
                        Toast.makeText(context, "Removed from Wishlist", Toast.LENGTH_SHORT).show();
                    } else {
                        dbHelper.getDao().addData(
                                new WislistItem(arrayList.get(position).getImage(), arrayList.get(position).getName(), arrayList.get(position).getPrice())

                        );
                        Toast.makeText(context, "Added in Wishlist", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iv_pic,heart;
        TextView tv_name,tv_price;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);


            iv_pic = (itemView).findViewById(R.id.iv_pic);
            tv_name = (itemView).findViewById(R.id.tv_name);
            tv_price = (itemView).findViewById(R.id.tv_price);
            heart = itemView.findViewById(R.id.heart);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, VegetableDetail.class);
            intent.putExtra("image",arrayList.get(position).getImage());
            intent.putExtra("name",arrayList.get(position).getName());
            intent.putExtra("price",arrayList.get(position).getPrice());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
