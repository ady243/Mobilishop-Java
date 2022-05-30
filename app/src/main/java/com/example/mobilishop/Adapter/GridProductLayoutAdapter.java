package com.example.mobilishop.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobilishop.Activity.ProductDetailsActivity;
import com.example.mobilishop.Model.HorizontalProductScrollModel;
import com.example.mobilishop.R;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductScrollModel> horizontalProductScrollModelList;
    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList){
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }
    @Override
    public int getCount(){
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
           view.setOnClickListener(v -> {
               Intent productDetailsIntent = new Intent(parent.getContext(), ProductDetailsActivity.class);
               parent.getContext().startActivity(productDetailsIntent);
           });

            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDescription = view.findViewById(R.id.h_s_product_description);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            productImage.setImageResource(horizontalProductScrollModelList.get(position).getProduceImage());
            productTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProductScrollModelList.get(position).getProductDescription());
            productPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());

        }else{
            // to do else
            view = convertView;
        }
        return  view;
    }
}
