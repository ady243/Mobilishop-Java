package com.example.mobilishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Offres du jour");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if(layout_code == 0) {


            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();

            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 1, "3", 27, "590 €", "paiement à la livraison", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 0, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 2, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 4, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 1, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 1, "3", 27, "590 €", "paiement à la livraison", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 0, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 2, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 4, "3", 27, "590 €", "500 €", ""));
            wishlistModelList.add(new WishlistModel(R.drawable.fauteuil, "Chaise en bois", 1, "3", 27, "590 €", "500 €", ""));


            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if(layout_code == 1) {


            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.fauteuil1, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catlit, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.hero4, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catbain, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catdeco, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catrangement, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.lamp1, "Fauteil", " En bois 54823", "300 €"));

            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.fauteuil1, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catlit, "Fauteil", " En bois 54823", "300 €"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.hero4, "Fauteil", " En bois 54823", "300 €"));

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}