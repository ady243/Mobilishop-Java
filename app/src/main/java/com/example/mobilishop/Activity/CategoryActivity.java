package com.example.mobilishop.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilishop.Adapter.HomePageAdapter;
import com.example.mobilishop.Model.HomePageModel;
import com.example.mobilishop.Model.HorizontalProductScrollModel;
import com.example.mobilishop.R;
import com.example.mobilishop.Model.SliderModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {


    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);





        ///////////// to do banner slider



        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.home,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.danger,"#ffffff"));
         sliderModelList.add(new SliderModel(R.mipmap.greenemail,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.emaiil,"#ffffff")); // the place for the mail
         sliderModelList.add(new SliderModel(R.mipmap.emaiil,"#ffffff"));
           sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#ffffff"));
         sliderModelList.add(new SliderModel(R.mipmap.emaiil,"#ffffff"));
         sliderModelList.add(new SliderModel(R.mipmap.emaiil,"#ffffff")); // for the cart
         sliderModelList.add(new SliderModel(R.drawable.ic_baseline_account_circle_24,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.home,"#ffffff"));



        sliderModelList.add(new SliderModel(R.mipmap.danger,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.greenemail,"#ffffff")); // the place for the mail
        sliderModelList.add(new SliderModel(R.mipmap.emaiil,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#fffff"));
        sliderModelList.add(new SliderModel(R.mipmap.home,"#ffffff"));



        ///////////// to do banner slider



        //////Horizontal Product layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 €"));

        //////Horizontal Product layout



        ////////////////////////////////////////////////////



        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel>homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        homePageModelList.add(new HomePageModel(1,R.drawable.ic_baseline_email_24,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));

       homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
       homePageModelList.add(new HomePageModel(0,sliderModelList));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.main_search_icon){
            //to do search
            return true;
        }else if(id == R.id.main_notification_icon){
            //to do notification
            return true;
        }else if(id == R.id.main_cart_icon){
            //to do cart
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}