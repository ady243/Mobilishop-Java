package com.example.mobilishop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAccountFragment} factory method to
 * create an instance of this fragment.
 */
public class MyAccountFragment extends Fragment {





    public MyAccountFragment() {
        // Required empty public constructor
    }

    public static final int MANAGE_ADDRESS =1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }
}