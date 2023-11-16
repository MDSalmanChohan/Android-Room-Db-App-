package com.example.drawernavigation.ModelClass;

import android.content.Intent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "Wishlist")
public class WislistItem {

    @PrimaryKey(autoGenerate = true)
    private int id ;


    @ColumnInfo(name ="Image")
    Integer image;

    @ColumnInfo(name = "Name")
    String name;

    @ColumnInfo(name = "Price")
    String price;




    public WislistItem(Integer image, String name, String price) {

        this.image = image;
        this.name = name;
        this.price = price;

    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
