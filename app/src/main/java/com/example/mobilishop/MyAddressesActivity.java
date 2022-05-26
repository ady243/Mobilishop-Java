package com.example.mobilishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myAddressesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Mon adresse");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        myAddressesRecyclerView = findViewById(R.id.addresses_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressesRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au rois","75011"));


        AddressesAdapter addressesAdapter = new AddressesAdapter(addressesModelList);
        myAddressesRecyclerView.setAdapter(addressesAdapter);
        addressesAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}