package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.model.Contacts;

public class Mainactivity2Handler {
    Context context;
    Contacts contacts;
        ContactViewModel contactViewModel;

    public Mainactivity2Handler(Context context, Contacts contacts, ContactViewModel contactViewModel) {
        this.context = context;
        this.contacts = contacts;
        this.contactViewModel = contactViewModel;
    }
    public void onBtnClicked(View view) {
        if (contacts.getName() == null || contacts.getEmail() == null) {
            Toast.makeText(context, "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);

            Contacts c = new Contacts(
                    contacts.getName(),
                    contacts.getEmail()
            );
            contactViewModel.addLogindetail(c);

            context.startActivity(i);

        }
    }

}
