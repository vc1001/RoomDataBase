package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.model.Contacts;

import java.util.ArrayList;

public class MyClickHandler3 {
    Context context;
    Contacts login;
    ContactViewModel loginviewmodel;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    MyAdapter adapter;
    ArrayList<Contacts> contacts;

    public MyClickHandler3(Context context, Contacts login, ContactViewModel loginviewmodel) {
        this.context = context;
        this.login = login;
        this.loginviewmodel = loginviewmodel;
    }
    public void onBtnnClicked(View view){
        loginviewmodel.updateLogindetail(login);
        contactsArrayList.remove(login);
        loginviewmodel.addLogindetail(login);
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
    public void onCloseclicked(View view){
        Intent intent=new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);

    }
}
