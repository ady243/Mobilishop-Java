package com.example.mobilishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {


    private RecyclerView deliveryRecyclerView;
    private Button changeORaddNewAdressBtn;

    public static final int SELECT_ADDRESS = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Livraison");

        deliveryRecyclerView = findViewById(R.id.delivery_recyclerview);

        changeORaddNewAdressBtn = findViewById(R.id.cart_items_recyclerview);
        changeORaddNewAdressBtn = findViewById(R.id.change_or_add_adress_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",2,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",0,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.fauteuil1,"2 Siege",2,"€ 500","€ 590",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Prix (3 Articles","€ 1270","Gratuit","€ 1270","€ 590"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeORaddNewAdressBtn.setVisibility(View.VISIBLE);
changeORaddNewAdressBtn.setOnClickListener(v -> {
    Intent myAddressesIntent = new Intent(DeliveryActivity.this,MyAddressesActivity.class);
    startActivity(myAddressesIntent);
});
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}