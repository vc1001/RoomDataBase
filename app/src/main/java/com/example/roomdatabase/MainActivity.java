package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.DataBase.Contactdatabase;
import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.databinding.ActivityMainBinding;
import com.example.roomdatabase.model.Contacts;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewInterface {
     Contactdatabase contactdatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;
    private MainactivityCilckHandler handlers;
    ContactViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainactivityCilckHandler(this);

        mainBinding.setClick(handlers);


        RecyclerView recyclerView = mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        contactdatabase = Contactdatabase.getInstance(this);


        viewmodel = new ViewModelProvider(this)
                .get(ContactViewModel.class);



        viewmodel.getLogindata3().observe(this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts) {

                        contactsArrayList.clear();

                        for (Contacts c : contacts) {
                            contactsArrayList.add(c);
                        }

                        myAdapter.notifyDataSetChanged();

                    }
                });



        myAdapter = new MyAdapter(contactsArrayList,this);


        recyclerView.setAdapter(myAdapter);




        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());


                viewmodel.deleteLogindetail(c);
                Snackbar snackbar=Snackbar.make(mainBinding.getRoot(),"Item Deleted",Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                viewmodel.addLogindetail(c);


                            }
                        })
                        .show();

            }
        }).attachToRecyclerView(recyclerView);


    }

    @Override
    public void OnItemClick(int position) {
        Intent intent=new Intent(MainActivity.this, MainActivity3.class);
        intent.putExtra("name",contactsArrayList.get(position).getName());
        intent.putExtra("email",contactsArrayList.get(position).getEmail());

        startActivity(intent);

    }
}