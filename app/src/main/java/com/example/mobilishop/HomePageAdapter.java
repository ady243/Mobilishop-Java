package com.example.mobilishop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelListList;
    private RecyclerView.RecycledViewPool recycledViewPool;


    public HomePageAdapter(List<HomePageModel> homePageModelList){
       this.homePageModelListList = homePageModelList;
       recycledViewPool = new RecyclerView.RecycledViewPool();
    }


    @Override
    public int getItemViewType(int position){
    switch (homePageModelListList.get(position).getType()){
        case  0:
            return HomePageModel.BANNER_SLIDER;


        case 1:
            return HomePageModel.STRIP_AD_BANNER;
        case 2:
            return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
        case 3:
            return HomePageModel.GRID_PRODUCT_VIEW;
        default:
            return -1;
    }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        switch (viewType){
            case HomePageModel.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_ad_layout,viewGroup,false);
                return  new BannerSliderViewholder(bannerSliderView);

            case HomePageModel.STRIP_AD_BANNER:
                View stripAdView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_ad_layout,viewGroup,false);
                return  new StripAdBannerViewholder(stripAdView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout,viewGroup,false);
                return  new HorizontalProductViewholder(horizontalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout,viewGroup,false);
                return  new GridProductViewholder(gridProductView);


            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
       switch (homePageModelListList.get(position).getType()){
           case HomePageModel.BANNER_SLIDER:

               List<SliderModel>sliderModelList = homePageModelListList.get(position).getSliderModelList();
               ((BannerSliderViewholder)viewHolder).setBannerSliderViewPager(sliderModelList);
               break;

               case HomePageModel.STRIP_AD_BANNER:
                   int resource = homePageModelListList.get(position).getResource();
                   String color = homePageModelListList.get(position).getBackgroundColor();

                   ((StripAdBannerViewholder)viewHolder).setStripAd(resource,color);
                   break;
                   // getHorizontalProductScrollModelList à verifier et getHorizontalProductLayout
           case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
              String horizontalLayoutTitle = homePageModelListList.get(position).getTitle();
              List<HorizontalProductScrollModel>horizontalProductScrollModelList = homePageModelListList.get(position).getHorizontalProductScrollModelList();
               ((HorizontalProductViewholder)viewHolder).setHorizontalProductLayout(horizontalProductScrollModelList,horizontalLayoutTitle);
               break;
              case HomePageModel.GRID_PRODUCT_VIEW:
                  String gridLayoutTitle = homePageModelListList.get(position).getTitle();
                  List<HorizontalProductScrollModel>gridProductScrollModelList = homePageModelListList.get(position).getHorizontalProductScrollModelList();
                  ((GridProductViewholder)viewHolder).setGridProductLayout(gridProductScrollModelList,gridLayoutTitle);
           default:
               return;
       }
    }

    @Override
    public int getItemCount() {
        return homePageModelListList.size();
    }

    public class BannerSliderViewholder extends RecyclerView.ViewHolder{

        private ViewPager bannerSliderViewPager;

        private List<SliderModel> sliderModelList;
        private int currentPage = 2;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIMER = 3000;

        public BannerSliderViewholder(View itemView){
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_view_pager);


        }


        private void setBannerSliderViewPager(List<SliderModel> sliderModelList){
            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            bannerSliderViewPager.setAdapter(sliderAdapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);

            bannerSliderViewPager.setCurrentItem(currentPage);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int il) {

                }

                @Override
                public void onPageSelected(int i) {
                    currentPage = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if(i == ViewPager.SCROLL_STATE_IDLE){
                        pageLooper(sliderModelList);
                    }
                }
            };
            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startBannerSliderShow(sliderModelList);

            bannerSliderViewPager.setOnTouchListener((v, event) -> {
                pageLooper(sliderModelList);
                stopBannerSlideShow();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    startBannerSliderShow(sliderModelList);
                }
                return false;
            });
        }
        private void pageLooper(List<SliderModel> sliderModelList){
            if (currentPage == sliderModelList.size() - 2){
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }
            if (currentPage == 1){
                currentPage = sliderModelList.size()-3;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }
        }
        private void startBannerSliderShow(List<SliderModel> sliderModelList){
            Handler handler = new Handler();
            final Runnable update = () -> {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            },DELAY_TIME,PERIOD_TIMER);

        }
        private void stopBannerSlideShow(){
            timer.cancel();
        }
    }
    public class StripAdBannerViewholder extends RecyclerView.ViewHolder{

        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBannerViewholder(@NonNull View itemView) {
            super(itemView);
            stripAdImage = itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer = itemView.findViewById(R.id.strip_ad_container);

        }
        private void setStripAd(int resource,String color){
            stripAdImage.setImageResource(R.drawable.banner);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }
    public class HorizontalProductViewholder extends RecyclerView.ViewHolder{

        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllBtn;
        private RecyclerView horizontalRecyclerView;

        public HorizontalProductViewholder(@NonNull View itemView) {
            super(itemView);

            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalLayoutViewAllBtn = itemView.findViewById(R.id.horizontal_scroll_view_all_btn);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recycler_view);
            horizontalRecyclerView.setRecycledViewPool(recycledViewPool);
        }
        private void setHorizontalProductLayout(List<HorizontalProductScrollModel>horizontalProductScrollModelList,String title){

         horizontalLayoutTitle.setText(title);

          if(horizontalProductScrollModelList.size()>8){
              horizontalLayoutViewAllBtn.setVisibility(View.VISIBLE);
              horizontalLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent viewAllIntent = new Intent(itemView.getContext(),ViewAllActivity.class);
                      viewAllIntent.putExtra("layout_code",0);
                      itemView.getContext().startActivity(viewAllIntent);
                  }
              });

          }else{
              horizontalLayoutViewAllBtn.setVisibility(View.INVISIBLE);
          }

            HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation((LinearLayoutManager.HORIZONTAL));
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);
            horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();
        }
    }
    public class GridProductViewholder extends RecyclerView.ViewHolder{

        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBtn;
        private GridLayout gridProductLayout;



        public GridProductViewholder(@NonNull View itemView) {
            super(itemView);
             gridLayoutTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewAllBtn = itemView.findViewById(R.id.grid_product_layout_viewall_btn);
           gridProductLayout = itemView.findViewById(R.id.grid_layout);
        }
        private void setGridProductLayout(List<HorizontalProductScrollModel> horizontalProductScrollModelList,String title){
            gridLayoutTitle.setText(title);

            for(int x = 0;x < 4;x++){
                ImageView productImage = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_image);
                TextView productTitle = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_title);
                TextView productDiscription = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_description);
                TextView productPrice = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_price);
                gridProductLayout.getChildAt(x).setBackgroundColor(Color.parseColor("#fffff"));

                productImage.setImageResource(horizontalProductScrollModelList.get(x).getProduceImage());
                productTitle.setText(horizontalProductScrollModelList.get(x).getProductTitle());
                productDiscription.setText(horizontalProductScrollModelList.get(x).getProductDescription());
                productPrice.setText(horizontalProductScrollModelList.get(x).getProductPrice());
                gridProductLayout.getChildAt(x).setOnClickListener(v -> {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);

                });
            }


            gridLayoutViewAllBtn.setOnClickListener(v -> {
                Intent viewAllIntent = new Intent(itemView.getContext(),ViewAllActivity.class);
                viewAllIntent.putExtra("layout_code",1);
                itemView.getContext().startActivity(viewAllIntent);
            });
        }
    }
}
