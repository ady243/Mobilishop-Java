package com.example.mobilishop.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilishop.Fragment.SignInFragment;
import com.example.mobilishop.R;
import com.google.firebase.auth.FirebaseAuth;


public class ResetPasswordFragment extends Fragment {



    public ResetPasswordFragment() {
        // Required empty public constructor
    }

  private EditText registerEmail;
    private Button resetPasswordBtn;
    private TextView goBack;



    private FrameLayout parentFrameLayout;

    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_password, container, false);
        registerEmail = view.findViewById(R.id.forgot_password_email);
        resetPasswordBtn = view.findViewById(R.id.reset_password_btn);
        goBack = view.findViewById(R.id.tv_forgot_password_go_back);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }



    @Override
    public  void onViewCreated(View view, Bundle  savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        registerEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //to do button for reset password
        resetPasswordBtn.setOnClickListener(v -> {

            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(55,255,255,255));

            firebaseAuth.sendPasswordResetEmail(registerEmail.getText().toString())

                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(getActivity(),"email sent successfully!", Toast.LENGTH_SHORT);
                        }else{
                            //to do else of firebase Auth and register email

                           String error = task.getException().getMessage();
                           Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

                            //setText don't work
                        }

                        resetPasswordBtn.setEnabled(true);
                        resetPasswordBtn.setTextColor(Color.rgb(255,255,255));


                    });
        });

        //to do for the button of go back
        goBack.setOnClickListener(v -> setFragment(new SignInFragment()));
    }




    private void checkInputs(){
        if(TextUtils.isEmpty(registerEmail.getText())){
            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(55,255,255,255

            ));

        }else{
            resetPasswordBtn.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.argb(255,255,255,255));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}