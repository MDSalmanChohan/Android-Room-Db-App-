package com.example.drawernavigation.Adapter;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.drawernavigation.ModelClass.WislistItem;

import java.util.List;

@Dao
public interface CartDao {

//    @Query("Select * from CartTable")
//    List<CartEntity> getCart();

    @Insert
    public void addCart(CartEntity cartEntity);

    @Query("SELECT * FROM CartTable WHERE Image = :image")
    List<CartEntity> getFavoriteList1(String image);


    @Query("Update CartTable set Cart= :cartCount Where Image = :image")
    public void updateCart(String cartCount, String image);
}
