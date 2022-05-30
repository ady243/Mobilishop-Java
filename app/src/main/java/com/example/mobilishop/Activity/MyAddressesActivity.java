package com.example.mobilishop.Activity;

import static com.example.mobilishop.Activity.DeliveryActivity.SELECT_ADDRESS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mobilishop.Adapter.AddressesAdapter;
import com.example.mobilishop.Model.AddressesModel;
import com.example.mobilishop.R;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myAddresseRecyclerView;
    private Button deliverHereBtn;
    private static AddressesAdapter addressesAdapter;

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
        deliverHereBtn = findViewById(R.id.deliver_here_btn);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddresseRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011",true));
        addressesModelList.add(new AddressesModel("Mobili Shop","12 rue la fontaine au roi","75011",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if(mode == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else{
            deliverHereBtn.setVisibility(View.GONE);
        }

         addressesAdapter = new AddressesAdapter(addressesModelList,mode);
        myAddresseRecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddresseRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect, int select){
        addressesAdapter.notifyDataSetChanged(deselect);
        addressesAdapter.notifyDataSetChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}