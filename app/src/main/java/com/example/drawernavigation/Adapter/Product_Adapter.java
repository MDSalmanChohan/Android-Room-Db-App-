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
import com.example.drawernavigation.ModelClass.WislistItem;
import com.example.drawernavigation.ModelClass.food_model;
import com.example.drawernavigation.ProductDetail;
import com.example.drawernavigation.R;

import java.util.ArrayList;
import java.util.List;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.myViewHolder> {

    Context context;
    ArrayList<food_model> arrayList;
    boolean like;
    public Product_Adapter(Context context, ArrayList<food_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.product_design,parent,false);
       return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        FavDatabase dbHelper = FavDatabase.getInstance(context);
        FavDatabase database = FavDatabase.getInstance(context);
        holder.iv_pic.setImageResource(arrayList.get(position).getImage());
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_price.setText(arrayList.get(position).getPrice());
//        holder.heart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (like){
//                    like = false;
//                    holder.heart.setImageResource(R.drawable.love);
//                }
//                else
//                {
//                    like = true;
//                    holder.heart.setImageResource(R.drawable.heart);
//                }
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

                       // dbHelper.getDao().deleteRecord(String.valueOf(arrayList.get(position).getImage()));
                        Toast.makeText(context, "Already from Wishlist", Toast.LENGTH_SHORT).show();
                    } else {
                        dbHelper.getDao().addData(
                                new WislistItem(arrayList.get(position).getImage(), arrayList.get(position).getName(), arrayList.get(position).getPrice())

                        );
                        Toast.makeText(context, "Added in Wishlist", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.plus.setVisibility(View.VISIBLE);

                food_model popular=arrayList.get(position);
                int newQuantity=popular.getQuantity()+1;
                if (newQuantity>0){
                    holder.minus.setVisibility(View.VISIBLE);
                    database.getCartDao().addCart(

                        new CartEntity(arrayList.get(position).getImage(),arrayList.get(position).getName(),arrayList.get(position).getPrice(),1)
                );
                    Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
                }
                popular.setQuantity(newQuantity);
                holder.add.setText(String.valueOf(newQuantity));
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food_model popular=arrayList.get(position);
                int newQuantity=popular.getQuantity()+1;
                if (newQuantity>0){
                    holder.minus.setVisibility(View.VISIBLE);



                    List<CartEntity> cartEntities = database.getCartDao().getFavoriteList1(String.valueOf(arrayList.get(position).getImage()));
                   if (cartEntities.size() > 0)
                   {
                        holder.add.getText().toString();
                        database.getCartDao().updateCart(String.valueOf(newQuantity),String.valueOf(arrayList.get(position).getImage()));
                   }
                    Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
                }
                popular.setQuantity(newQuantity);
                holder.add.setText(String.valueOf(newQuantity));
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food_model popular=arrayList.get(position);
                List<CartEntity> cartEntities = database.getCartDao().getFavoriteList1(String.valueOf(arrayList.get(position).getImage()));
                Log.e("TAG", "onClick: "+cartEntities.toString() );

                int newQuantity=popular.getQuantity()-1;
                popular.setQuantity(newQuantity);
                if(newQuantity==0){
                    holder.minus.setVisibility(View.GONE);
                    holder.add.setText("ADD");

                    if (cartEntities.size() < 0)
                    {
                        Log.e("sdfdf", "onClick: "+cartEntities.toString() );
                        holder.add.getText().toString();
                        database.getCartDao().updateCart(String.valueOf(newQuantity),String.valueOf(arrayList.get(position).getImage()));
                    }

                }
                else{

                    holder.add.setText(String.valueOf(newQuantity));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView iv_pic,heart,minus,plus;
        TextView tv_name,tv_price,add;
        public myViewHolder(@NonNull View itemView) {
           super(itemView);

            iv_pic = (itemView).findViewById(R.id.iv_pic);
            tv_name = (itemView).findViewById(R.id.tv_name);
            tv_price = (itemView).findViewById(R.id.tv_price);
            heart = itemView.findViewById(R.id.heart);
            minus = itemView.findViewById(R.id.lessQty);
            plus = itemView.findViewById(R.id.add);
            add = itemView.findViewById(R.id.tv_add);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
         int position = getAdapterPosition();
         Intent intent = new Intent(context, ProductDetail.class);
         intent.putExtra("image",arrayList.get(position).getImage());
         intent.putExtra("name",arrayList.get(position).getName());
         intent.putExtra("price",arrayList.get(position).getPrice());
         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         context.startActivity(intent);
        }
    }
}
