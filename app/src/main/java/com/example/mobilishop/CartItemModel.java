package com.example.mobilishop;

public class CartItemModel {

    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT=1;


    private int type;

    public int getType() {
        return type;
    }

    /////// cart item

    private int productImage;
    private String productTitle;
    private int couponsGratuit;
    private String productPrice;
    private String cuttedPrice;
    private int productQuantity;
    private int offersApplied;
    private int couponsApplique;


    public CartItemModel(int type, int productImage, String productTitle, int couponsGratuit, String productPrice, String cuttedPrice, int productQuantity, int offersApplied, int couponsApplique) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.couponsGratuit = couponsGratuit;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuantity;
        this.offersApplied = offersApplied;
        this.couponsApplique = couponsApplique;
    }

    public static int getCartItem() {
        return CART_ITEM;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getCouponsGratuit() {
        return couponsGratuit;
    }

    public void setCouponsGratuit(int couponsGratuit) {
        this.couponsGratuit = couponsGratuit;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOffersApplied() {
        return offersApplied;
    }

    public void setOffersApplied(int offersApplied) {
        this.offersApplied = offersApplied;
    }

    public int getCouponsApplique() {
        return couponsApplique;
    }

    public void setCouponsApplique(int couponsApplique) {
        this.couponsApplique = couponsApplique;
    }
/////// cart item



    /////cart total
    private String totalItems;
    private String totalItemPrice;
    private String deliveryPrice;
    private String saveAmount;
    private String totalAmount;

    public CartItemModel(int type, String totalItems, String totalItemPrice, String deliveryPrice,String totalAmount, String saveAmount) {
      this.totalAmount = totalAmount;
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemPrice = totalItemPrice;
        this.deliveryPrice = deliveryPrice;
        this.saveAmount = saveAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(String saveAmount) {
        this.saveAmount = saveAmount;
    }

    /////cart total

}



//// if i found an error  come from here Items