package com.example.roomdatabase.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.DAO.Contactdao;
import com.example.roomdatabase.model.Contacts;

@Database(entities = {Contacts.class},version = 1)
public abstract class Contactdatabase extends RoomDatabase {
    private static Contactdatabase contactdatabase;
    public abstract Contactdao contactdao();


    public static synchronized Contactdatabase getInstance(Context context){
        if (contactdatabase==null){
            contactdatabase= Room.databaseBuilder(context.getApplicationContext(),
                    Contactdatabase.class,"Login_db").fallbackToDestructiveMigration().build();
        }
        return contactdatabase;
    }

}
