package com.example.mobilishop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyWishlistFragment} factory method to
 * create an instance of this fragment.
 */
public class MyWishlistFragment extends Fragment {



    public MyWishlistFragment() {
        // Required empty public constructor
    }


    private RecyclerView wishlistRecylerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        wishlistRecylerView = view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecylerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();

        wishlistModelList.add(new WishlistModel(R.drawable.fauteuil,"Chaise en bois",1,"3",27,"590 €","paiement à la livraison",""));
        wishlistModelList.add(new WishlistModel(R.drawable.fauteuil,"Chaise en bois",0,"3",27,"590 €","500 €",""));
        wishlistModelList.add(new WishlistModel(R.drawable.fauteuil,"Chaise en bois",2,"3",27,"590 €","500 €",""));
        wishlistModelList.add(new WishlistModel(R.drawable.fauteuil,"Chaise en bois",4,"3",27,"590 €","500 €",""));
        wishlistModelList.add(new WishlistModel(R.drawable.fauteuil,"Chaise en bois",1,"3",27,"590 €","500 €",""));

      WishlistAdapter wishlistAdapter =new WishlistAdapter(wishlistModelList);
      wishlistRecylerView.setAdapter(wishlistAdapter);
      wishlistAdapter.notifyDataSetChanged();
        return  view;
    }
}