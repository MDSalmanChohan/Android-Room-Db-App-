package com.example.drawernavigation.Adapter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.drawernavigation.ModelClass.Model;
import com.example.drawernavigation.ModelClass.WislistItem;

import java.util.List;

@Dao
public interface MyInterface {


    @Query("Select * from Wishlist")
    List<WislistItem> getFavoriteList();

    @Insert
    public void addData(WislistItem wislistItem);


    @Query("SELECT * FROM Wishlist WHERE Image = :image")
    List<WislistItem> getFavoriteList1(String image);

    @Query("DELETE  FROM Wishlist WHERE Image = :image")
    public void deleteRecord(String image);





//    List<WislistItem> searchItem();
//    @Query("Select * from Wishlist")
//    WislistItem getItem();


}

