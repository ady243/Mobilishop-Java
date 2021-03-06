package com.example.mobilishop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilishop.Adapter.CategoryAdapter;
import com.example.mobilishop.Adapter.HomePageAdapter;
import com.example.mobilishop.Model.CategoryModel;
import com.example.mobilishop.Model.HomePageModel;
import com.example.mobilishop.Model.HorizontalProductScrollModel;
import com.example.mobilishop.Model.SliderModel;
import com.example.mobilishop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

   public HomeFragment(){
       // Required empty public constructor
   }

   private RecyclerView categoryRecyclerView;
   private CategoryAdapter categoryAdapter;
   private RecyclerView testing;





    //////Horizontal Product layout
   private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    //////Horizontal Product layout
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       //inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);

       categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
       LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
       layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
       categoryRecyclerView.setLayoutManager(layoutManager);

      final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
     categoryModelList.add(new CategoryModel("link", "Home"));
       categoryModelList.add(new CategoryModel("link", "Electronics"));
       categoryModelList.add(new CategoryModel("link", "Appliances"));
       categoryModelList.add(new CategoryModel("link", "Furniture"));
       categoryModelList.add(new CategoryModel("link", "Appliances"));
       categoryModelList.add(new CategoryModel("link", "Furniture"));
       categoryModelList.add(new CategoryModel("link", "Furniture"));


       categoryAdapter = new CategoryAdapter(categoryModelList);
       categoryRecyclerView.setAdapter(categoryAdapter);
       categoryAdapter.notifyDataSetChanged();

       ///////////// to do banner slider

       List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

       sliderModelList.add(new SliderModel(R.mipmap.catbain,"#ffffff"));
       sliderModelList.add(new SliderModel(R.mipmap.lamp1,"#ffffff"));
       sliderModelList.add(new SliderModel(R.mipmap.plant1,"#ffffff"));
       sliderModelList.add(new SliderModel(R.mipmap.plant3,"#ffffff"));
       sliderModelList.add(new SliderModel(R.mipmap.catbain,"#ffffff"));
       sliderModelList.add(new SliderModel(R.mipmap.plant2,"#ffffff"));

      ///////////// to do banner slider


       //////Horizontal Product layout

       List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fauteuil,"Fauteil"," En bois 54823","300 ???"));
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.fauteuil1,"Fauteil"," En bois 54823","300 ???"));
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catlit,"Fauteil"," En bois 54823","300 ???"));
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.hero4,"Fauteil"," En bois 54823","300 ???"));
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catbain,"Fauteil"," En bois 54823","300 ???"));
       horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.catdeco,"Fauteil"," En bois 54823","300 ???"));

       //////Horizontal Product layout



       ////////////////////////////////////////////////////


       testing = view.findViewById(R.id.home_page_recyclerview);
       LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
       testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       testing.setLayoutManager(testingLayoutManager);

       List<HomePageModel>homePageModelList = new ArrayList<>();
       homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
       homePageModelList.add(new HomePageModel(0,sliderModelList));
       homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
       homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(0,sliderModelList));
       homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
       homePageModelList.add(new HomePageModel(0,sliderModelList));
       homePageModelList.add(new HomePageModel(1,R.drawable.hero1,"#ffffff"));
       homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(0,sliderModelList));
       homePageModelList.add(new HomePageModel(3,"Offre du Jour",horizontalProductScrollModelList));
       homePageModelList.add(new HomePageModel(2,"Offre du Jour",horizontalProductScrollModelList));





       HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
       testing.setAdapter(adapter);
       adapter.notifyDataSetChanged();

       ////////////////////////////////////////////////////
       return view;
   }


}