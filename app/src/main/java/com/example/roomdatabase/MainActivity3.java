package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.databinding.ActivityMain3Binding;
import com.example.roomdatabase.model.Contacts;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding activityMain3Binding;
    private Contacts login;
    private MyClickHandler3 handler;
    private ContactViewModel loginviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        ContactViewModel myViewModel = new ViewModelProvider(this)
                .get(ContactViewModel.class);

        login = new Contacts();
        handler = new MyClickHandler3(this, login, myViewModel);
        String a1 = getIntent().getStringExtra("name");
        String a2 = getIntent().getStringExtra("email");
        login.setName(a1);
        login.setEmail(a2);
        activityMain3Binding.executePendingBindings();
        activityMain3Binding.setContact(login);
        activityMain3Binding.setClickHandler(handler);

    }
}