package com.example.mobilishop;
import com.example.mobilishop.Model.CartItemModel;
import com.example.mobilishop.Model.CategoryModel;
import com.example.mobilishop.Model.WishlistModel;
import com.example.mobilishop.Model.MyOrderItemModel;
import com.example.mobilishop.Model.ProductSpecificationModel;
import com.example.mobilishop.Model.HorizontalProductScrollModel;
import com.example.mobilishop.Fragment.SignInFragment;
import com.example.mobilishop.Fragment.SignUpFragment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    //CartModel
    @POST("{{mobilishop.com}}/products")
    Call<CartItemModel> CART_ITEM_MODEL_CALL(@Body CartItemModel cartItemModel);

    //Categories
    @POST("")
    Call<CategoryModel> CATEGORY_MODEL_CALL(@Body CategoryModel categoryModel);

   //Product

    @POST("")
    Call<ProductSpecificationModel> PRODUCT_SPECIFICATION_MODEL_CALL(@Body ProductSpecificationModel productSpecificationModel);

    //Order
    @POST("")
    Call<MyOrderItemModel>MY_ORDER_ITEM_MODEL_CALL(@Body MyOrderItemModel myOrderItemModel);

    //ProductScroll
    @POST("")
    Call<HorizontalProductScrollModel>HORIZONTAL_PRODUCT_SCROLL_MODEL_CALL(@Body HorizontalProductScrollModel horizontalProductScrollModel);

    //wishList
    @POST("")
    Call<WishlistModel>WISHLIST_MODEL_CALL(@Body WishlistModel wishlistModel);

    //SignIN
    @GET("{{mobilishop.com}}/login")
    Call<SignInFragment>SIGN_IN_FRAGMENT_CALL(@Body SignInFragment signInFragment);

    @GET("{{mobilishop.com}}/register")
    Call<SignUpFragment>SIGN_UP_FRAGMENT_CALL(@Body SignUpFragment signUpFragment);
}
