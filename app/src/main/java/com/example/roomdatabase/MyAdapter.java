package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.OnContactClickListener;
import com.example.roomdatabase.R;
import com.example.roomdatabase.databinding.ItemListBinding;
import com.example.roomdatabase.model.Contacts;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;
    public Contacts contact;
    private OnContactClickListener onContactClickListener;

    public MyAdapter(ArrayList<Contacts> contacts, OnContactClickListener onContactClickListener) {
        this.contacts = contacts;
        this.onContactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemListBinding contactListItemBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_list,
                        parent,
                        false
                );

        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        Contacts currentContact = contacts.get(position);

        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if (contacts != null) {
            return contacts.size();
        } else {
            return 0;
        }
    }


    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();

    }


    class ContactViewHolder extends RecyclerView.ViewHolder {

        private ItemListBinding contactListItemBinding;

        public ContactViewHolder(@NonNull ItemListBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
            contactListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onContactClickListener !=null){
                        int position1=getAdapterPosition();
                        if (position1!=RecyclerView.NO_POSITION){
                            onContactClickListener.onContactClick(position1);
                        }
                    }
                }
            });
        }
    }
}


