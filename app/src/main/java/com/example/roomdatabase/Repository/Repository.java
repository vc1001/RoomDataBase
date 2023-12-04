package com.example.roomdatabase.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase.DAO.Contactdao;
import com.example.roomdatabase.DataBase.Contactdatabase;
import com.example.roomdatabase.model.Contacts;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final Contactdao contactdao;
    private final ExecutorService service;
    private final Handler handler;

    public Repository(Application application) {
        Contactdatabase contactdatabase=Contactdatabase.getInstance(application);
        this.contactdao = contactdatabase.contactdao();
        service = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

    }
    public void addLogin(Contacts contacts){
        service.execute(() ->{
            contactdao.insert(contacts);
        });
    }
    public void deleteLogin(Contacts contacts) {
        service.execute(() -> {
            contactdao.delete(contacts);
        });
    }
    public void updateLogin(Contacts contacts){
        service.execute(() ->{
            contactdao.update(contacts);
        });
    }
    public LiveData<List<Contacts>> getlogindata2(){
        return contactdao.getlogindata();
    }
}

