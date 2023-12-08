package com.example.roomdatabase;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomdatabase.ViewModel.ContactViewModel;
import com.example.roomdatabase.databinding.FragmentUpdateBinding;
import com.example.roomdatabase.model.Contacts;

public class UpdateFragment extends DialogFragment {
    private Contacts login;
    private Context context;

    private ContactViewModel myViewModel;
   // private MyClickHandler3 handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  View returnView = inflater.inflate(R.layout.fragment_update, container, false);
        FragmentUpdateBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false);
         myViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        login = new Contacts();
    //   handler=new MyClickHandler3(getContext(),login,myViewModel);
        if (getArguments() != null) {
            String a1 = getArguments().getString("name");
            String a2 = getArguments().getString("email");
            String a3 = String.valueOf(getArguments().getInt("id", -6));
            login.setName(a1);
            login.setEmail(a2);
            login.setId(Integer.parseInt(a3));
            binding.setContact(login);
         //   binding.setClick(handler);

        }
    //    binding.setLifecycleOwner(this);
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getName().isEmpty() || login.getEmail().isEmpty()) {
                    Toast.makeText(context, "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
                } else {
                    if (myViewModel != null) {
                        myViewModel.updateLogindetail(login);
                        Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
                        startActivity(intent);
//                    if (myViewModel != null) {
//                        myViewModel.updateLogindetail(login);
//                        myViewModel.addLogindetail(login);
//                        Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
//                        startActivity(intent);
                    } else {
                        Toast.makeText(context, "Data is not Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }


}