package com.example.mobilishop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mobilishop.Adapter.ProductDetailsAdapter;
import com.example.mobilishop.Adapter.ProductImagesAdapter;
import com.example.mobilishop.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
private ViewPager productImagesViewPager;
private TabLayout viewpagerIndicator;

    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;


    ///////////////// rating layout

    private LinearLayout rateNowContainer;

    /////////////////rating layout


    private Button buyNowBtn;

    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
   private FloatingActionButton addToWishlistBtn;
    private boolean showCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      productImagesViewPager = findViewById(R.id.product_image_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishlistBtn = findViewById(R.id.add_to_wishlist_btn);
        productDetailsViewpager = findViewById(R.id.product_details_viewpager);
        productDetailsTablayout = findViewById(R.id.product_details_tablayout);
        buyNowBtn = findViewById(R.id.buy_now_btn);


        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.mipmap.lamp1);
        productImages.add(R.mipmap.lamp1);
        productImages.add(R.mipmap.lamp1);
        productImages.add(R.mipmap.lamp1);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewpagerIndicator.setupWithViewPager(productImagesViewPager,true);

          addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(ALREADY_ADDED_TO_WISHLIST){
                      ALREADY_ADDED_TO_WISHLIST = false;
                      addToWishlistBtn.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));

                  }else{
                      ALREADY_ADDED_TO_WISHLIST = true;
                      addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.principal));
                  }
              }
          });

          productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));

          productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));

          productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
              @Override
              public void onTabSelected(TabLayout.Tab tab) {
                  productDetailsViewpager.setCurrentItem(tab.getPosition());
              }

              @Override
              public void onTabUnselected(TabLayout.Tab tab) {


              }

              @Override
              public void onTabReselected(TabLayout.Tab tab) {

              }
          });

          //////////// rating layout

        rateNowContainer = findViewById(R.id.rate_now_container);
        for(int x = 0; x < rateNowContainer.getChildCount() ;x++){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }

        //////////// rating layout

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this, DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });

    }

    private void setRating(int starPosition) {
        for(int x = 0;x < rateNowContainer.getChildCount();x++){
            ImageView startBtn= (ImageView)rateNowContainer.getChildAt(x);
            startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x <= starPosition){
                startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
           finish();
            return true;
        }else if(id == R.id.main_search_icon){
            //to do notification
            return true;
        }else if(id == R.id.main_cart_icon){
            Intent cartItem = new Intent(ProductDetailsActivity.this, MainActivity.class);
            showCart = true;
            startActivity(cartItem);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}