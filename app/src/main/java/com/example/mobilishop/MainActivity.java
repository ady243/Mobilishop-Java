package com.example.mobilishop;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int Home_FRAGMENT = 0;
    private static  final int CART_FRAGMENT =1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT=3;
    private static  final int REWARDS_FRAGMENT = 4;
    private static  final int ACCOUNT_FRAGMENT=5;
    public static Boolean showCart = false;

    private FrameLayout frameLayout;
    private ImageView actionBarLogo;
      private  int currentFragment = -1;
      private NavigationView navigationView;
      private Window window;
      private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
       actionBarLogo = findViewById(R.id.actionbar_logo);
       setSupportActionBar(toolbar);

       window = getWindow();
       window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.main_framelayout);

        if (showCart){
           drawer.setDrawerLockMode(1);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            gotoFragment("Mon Panier",new MyCartFragment(),-2);
        }else{
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            setFragment(new HomeFragment(),Home_FRAGMENT);
        }


    }


    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            if(currentFragment == Home_FRAGMENT){
    currentFragment = 1;
            super.onBackPressed();


            }else{
                if (showCart){
                    showCart = false;
                    finish();
                }else {
                    actionBarLogo.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), Home_FRAGMENT);
                    navigationView.getMenu().getItem(0).setChecked(true);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //// Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == Home_FRAGMENT){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        setFragment(new MyCartFragment(),CART_FRAGMENT);

        if(id == R.id.main_search_icon){
            //to do search
            return true;
        }else if(id == R.id.main_notification_icon){
            //to do notification
            return true;
        }else if(id == R.id.main_cart_icon){
           gotoFragment("Mon Panier",new MyCartFragment(),CART_FRAGMENT);
            return true;
        }else if(id == android.R.id.home){
            if (showCart){
                showCart = false;
                finish();
                return  true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    private void gotoFragment(String title, Fragment fragment,int fragmentNo){
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNo);
        if(fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.nav_my_shop){

            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),Home_FRAGMENT);
        }
       else if( id == R.id.nav_my_order){
  gotoFragment("Mes Commandes",new MyOrdersFragment(),ORDERS_FRAGMENT);
            //to do my order
        }else if(id == R.id.nav_my_cart){
            gotoFragment("Mon Panier",new MyCartFragment(),CART_FRAGMENT);
        }else if (id == R.id.nav_my_reward){
           gotoFragment("Mes Récompenses", new MyRewardsFragment(),REWARDS_FRAGMENT);
            //to do my reward

            //to do account
        }else if(id == R.id.nav_my_wishlist){
           gotoFragment("Ma Liste de souhaits",new MyWishlistFragment(),WISHLIST_FRAGMENT);
        }else if(id == R.id.nav_my_account){
        gotoFragment("Mon Compte",new MyAccountFragment(),ACCOUNT_FRAGMENT);

        }else if(id == R.id.nav_sign_out){

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void  setFragment(Fragment fragment,int fragmentNo){
        if(fragmentNo != currentFragment) {
           if(fragmentNo == REWARDS_FRAGMENT){

           }else{
               window.setStatusBarColor(getResources().getColor(R.color.principal));

           }
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }



}