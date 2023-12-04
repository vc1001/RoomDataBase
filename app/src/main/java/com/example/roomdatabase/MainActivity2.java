package com.example.roomdatabase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.databinding.ActivityMain2Binding;
import com.example.roomdatabase.model.Contacts;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding activityMain2Binding;
    private   Mainactivity2Handler handler;
    private Contacts login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityMain2Binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);
        login=new Contacts();
        ContactViewModel myViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        handler = new Mainactivity2Handler(this,login,myViewModel);


        activityMain2Binding.setContact(login);
        activityMain2Binding.setClickHandler(handler);
    }
}