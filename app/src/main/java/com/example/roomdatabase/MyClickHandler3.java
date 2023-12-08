package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.model.Contacts;

import java.util.ArrayList;

public class MyClickHandler3  {
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
    public void onBtnnClicked(View view) {
        if (login.getName().isEmpty() || login.getEmail().isEmpty()) {
            Toast.makeText(context, "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
        } else {
            if (loginviewmodel != null) {
                loginviewmodel.updateLogindetail(login);
                loginviewmodel.addLogindetail(login);
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "Data is not Added", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void onCloseclicked(View view){
        Intent intent=new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);

    }
}
