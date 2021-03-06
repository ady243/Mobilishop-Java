package com.example.mobilishop.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilishop.Activity.ProductDetailsActivity;
import com.example.mobilishop.Model.HorizontalProductScrollModel;
import com.example.mobilishop.R;

import java.util.List;

public class HorizontalProductScrollAdapter  extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {


    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList){
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }


    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewHolder, int position) {

        int resource = horizontalProductScrollModelList.get(position).getProduceImage();
        String title = horizontalProductScrollModelList.get(position).getProductTitle();
        String description = horizontalProductScrollModelList.get(position).getProductDescription();
        String price = horizontalProductScrollModelList.get(position).getProductPrice();

        viewHolder.setProductImage(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductPrice(price);
        viewHolder.setProductionDescription(description);

    }

    @Override
    public int getItemCount() {
        if(horizontalProductScrollModelList.size() >8 ){
            return 8;
        }else{
            return horizontalProductScrollModelList.size();
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(v -> {
                Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                itemView.getContext().startActivity(productDetailsIntent);
            });

        }

        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }

        private void setProductionDescription(String description){
            productDescription.setText(description);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
