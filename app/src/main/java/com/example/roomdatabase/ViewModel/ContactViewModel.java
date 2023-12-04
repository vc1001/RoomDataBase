package com.example.roomdatabase.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabase.Repository.Repository;
import com.example.roomdatabase.model.Contacts;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Contacts>> allLogin;


    public ContactViewModel(@NonNull Application application) {
        super(application);
        this.repository=new Repository(application);
    }
    public LiveData<List<Contacts>> getLogindata3(){
        allLogin= repository.getlogindata2();
        return allLogin;

    }
    public void addLogindetail(Contacts contacts){
        repository.addLogin(contacts);


    }

    public void deleteLogindetail(Contacts contacts){
        repository.deleteLogin(contacts);
    }
    public void updateLogindetail(Contacts contacts){
        repository.updateLogin(contacts);
    }


}
