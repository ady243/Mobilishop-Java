package com.example.mobilishop;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass
 */

public class MyCartFragment extends Fragment {



    public MyCartFragment() {
        // Required empty public constructor
    }
    private RecyclerView cartItemsRecyclerView;
    private Button contunueBtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);

        contunueBtn = view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
         layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         cartItemsRecyclerView.setLayoutManager(layoutManager);

         List<CartItemModel> cartItemModelList = new ArrayList<>();
         cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",2,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",0,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",2,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Prix (3 Articles","€ 1270","Gratuit","€ 1270","€ 590"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        contunueBtn.setOnClickListener(v -> {
            Intent deliveryIntent = new Intent(getContext(),DeliveryActivity.class);
            getContext().startActivity(deliveryIntent);
        });

        return view;
    }
}