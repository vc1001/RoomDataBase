package com.example.roomdatabase.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.model.Contacts;

import java.util.List;

@Dao
public interface Contactdao {
    @Insert
    void insert(Contacts contacts);

    @Delete
    void delete(Contacts contacts);

    @Update
    void update(Contacts contacts);


    @Query("SELECT * FROM contact_table")
    LiveData<List<Contacts>> getlogindata();

}
