package com.example.mobilishop.Activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobilishop.R;
import com.example.mobilishop.Fragment.SignInFragment;
import com.example.mobilishop.Fragment.SignUpFragment;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    public  static  boolean onResetPasswordFragment = false ;
    public static boolean setSignUpFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout = findViewById(R.id.register_framelayout);
        if(setSignUpFragment){
            setDefaultFragment(new SignUpFragment());
        }else {
        setSignUpFragment = false;
            setDefaultFragment(new SignInFragment());
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(onResetPasswordFragment){
                onResetPasswordFragment = false;
                setFragment(new SignInFragment());

                return  false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    private void setDefaultFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}