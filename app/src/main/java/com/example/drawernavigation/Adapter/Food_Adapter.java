package com.example.drawernavigation.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.drawernavigation.FoodDetail;
import com.example.drawernavigation.ModelClass.WislistItem;
import com.example.drawernavigation.ModelClass.food_model;
import com.example.drawernavigation.R;

import java.util.ArrayList;
import java.util.List;

public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.myViewHolder> {

    Context context;
    ArrayList<food_model> arrayList;
    boolean like;
    public Food_Adapter(Context context, ArrayList<food_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
        @Override
        public int getItemViewType(int position) {
            if (arrayList.get(position).getName().toLowerCase().contains("biryani")) {
                return 0;
            }
            return 1;
        }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.food_design, parent, false);
            return new myViewHolder(view);
        }
        view = layoutInflater.inflate(R.layout.food_second_design, parent, false);
        return new myViewHolder(view); }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        FavDatabase dbHelper = FavDatabase.getInstance(context);
        if (arrayList.get(position).getName().contains("")) {

            holder.iv_pic.setImageResource(arrayList.get(position).getImage());
            holder.tv_name.setText(arrayList.get(position).getName());
            holder.tv_price.setText(arrayList.get(position).getPrice());
//            holder.heart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (like) {
//                        like = false;
//                        holder.heart.setImageResource(R.drawable.love);
//                    } else {
//
//                        like = true;
//                        holder.heart.setImageResource(R.drawable.heart);
//                    }
//                }
//            });
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
        else{
            holder.iv_pic.setImageResource(arrayList.get(position).getImage());
            holder.tv_name.setText(arrayList.get(position).getName());
            holder.tv_price.setText(arrayList.get(position).getPrice());
//            holder.heart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (like) {
//                        like = true;
//                        holder.heart.setImageResource(R.drawable.heart);
//                    } else {
//                        like = false;
//                        holder.heart.setImageResource(R.drawable.love);
//                    }
//                }
//            });

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
            Intent intent = new Intent(context, FoodDetail.class);
            intent.putExtra("image",arrayList.get(position).getImage());
            intent.putExtra("name",arrayList.get(position).getName());
            intent.putExtra("price",arrayList.get(position).getPrice());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
    public class myViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_pic,heart;
        TextView tv_name,tv_price;
        public myViewHolder2(@NonNull View itemView) {
            super(itemView);

            iv_pic = (itemView).findViewById(R.id.iv_pic);
            tv_name = (itemView).findViewById(R.id.tv_name);
            tv_price = (itemView).findViewById(R.id.tv_price);
            heart = itemView.findViewById(R.id.heart);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
