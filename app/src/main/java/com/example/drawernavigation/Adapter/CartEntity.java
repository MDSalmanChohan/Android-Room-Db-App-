package com.example.drawernavigation.Adapter;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CartTable")
public class CartEntity {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name ="Image")
    Integer image;

    @ColumnInfo(name = "Name")
    String name;

    @ColumnInfo(name = "Price")
    String price;
    @ColumnInfo(name = "Cart")
    Integer count;



    public CartEntity(Integer image, String name, String price, Integer count) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
