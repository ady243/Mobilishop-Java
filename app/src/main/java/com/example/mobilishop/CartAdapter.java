package com.example.mobilishop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CartAdapter  extends RecyclerView.Adapter {
private List<CartItemModel>cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
     switch (cartItemModelList.get(position).getType()){
         case 0:
             return CartItemModel.CART_ITEM;
         case 1:
             return CartItemModel.TOTAL_AMOUNT;
         default:
             return -1;
     }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType){
            case CartItemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new CartItemViewholder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                return new CartTotalAmountViewholder(cartTotalView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
  switch (cartItemModelList.get(position).getType()){
      case CartItemModel.CART_ITEM:
          int resource = cartItemModelList.get(position).getProductImage();
          String title = cartItemModelList.get(position).getProductTitle();
          int couponsGratuit = cartItemModelList.get(position).getCouponsGratuit();
          String productPrice = cartItemModelList.get(position).getProductPrice();
          String cuttedPrice = cartItemModelList.get(position).getCuttedPrice();
          int offersApplied = cartItemModelList.get(position).getOffersApplied();

          ((CartItemViewholder)viewHolder).setItemDetails(resource,title,couponsGratuit,productPrice,cuttedPrice,offersApplied);
          break;
          case CartItemModel.TOTAL_AMOUNT:

            String totalItems = cartItemModelList.get(position).getTotalItems();
              String totalItemPrice = cartItemModelList.get(position).getTotalItemPrice();
              String deliveryPrice = cartItemModelList.get(position).getDeliveryPrice();
              String totalAmount = cartItemModelList.get(position).getTotalAmount();
              String savedAmount = cartItemModelList.get(position).getSaveAmount();

              ((CartTotalAmountViewholder)viewHolder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);


              break;
      default:
          return;
  }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }
    class CartItemViewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView freeCouponsIcon;
        private TextView productTitle;
        private TextView couponsGratuit;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView couponsApplique;
        private TextView productQuantity;



        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            couponsGratuit = itemView.findViewById(R.id.tv_free_coupon);
            freeCouponsIcon = itemView.findViewById(R.id.free_coupon_icon);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            offersApplied = itemView.findViewById(R.id.offers_applied);
            couponsApplique = itemView.findViewById(R.id.coupons_applied);
            productQuantity = itemView.findViewById(R.id.product_quentity);
        }
        private void setItemDetails(int resource, String tile,int  couponsGratuitNo,String productPriceText,String cuttedPriceText,int offreAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(tile);
            if (  couponsGratuitNo > 0) {
                freeCouponsIcon.setVisibility(View.VISIBLE);
                couponsGratuit.setVisibility(View.VISIBLE);
                if(couponsGratuitNo == 1) {
                    couponsGratuit.setText("Gratuit" + couponsGratuitNo + "Coupon");
                }else{
                    couponsGratuit.setText("Gratuit" + couponsGratuitNo + "Coupons");
                }
            }else{
                freeCouponsIcon.setVisibility(View.INVISIBLE);
                couponsGratuit.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if(offreAppliedNo > 0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersApplied + "Offre appliqué");
            }else{
                offersApplied.setVisibility(View.INVISIBLE);
            }
            if(offreAppliedNo > 0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersApplied + "Offre appliqué");
            }else{
                offersApplied.setVisibility(View.INVISIBLE);
            }

        }
    }

    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{
       private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView saveAmount;


        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_items);
            totalItemsPrice = itemView.findViewById(R.id.total_items_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            saveAmount = itemView.findViewById(R.id.total_price);
            saveAmount = itemView.findViewById(R.id.saved_amount);
        }

        private void setTotalAmount(String totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText,String saveAmountText){
            totalItems.setText(totalItemText);
            totalItemsPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            saveAmount.setText(saveAmountText);
        }
    }
}
