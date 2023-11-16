package com.example.drawernavigation;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.drawernavigation.Adapter.CartDao;
import com.example.drawernavigation.Adapter.CartEntity;
import com.example.drawernavigation.Adapter.MyInterface;
import com.example.drawernavigation.ModelClass.WislistItem;

@Database(entities =
        {WislistItem.class, CartEntity.class}, version = 4)
public abstract class FavDatabase extends RoomDatabase {

    private static final String database_Name = "Favdb";
    private static FavDatabase instance = null;

    public static synchronized FavDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, FavDatabase.class, database_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract MyInterface getDao();

    public abstract CartDao getCartDao();
}
