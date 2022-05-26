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

    private RecyclerView myAddresseRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Mes Adresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAddresseRecyclerView = findViewById(R.id.addresses_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddresseRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011"));

        AddressesAdapter addressesAdapter = new AddressesAdapter(addressesModelList);
        myAddresseRecyclerView.setAdapter(addressesAdapter);
        addressesAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}