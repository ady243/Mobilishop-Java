package com.example.mobilishop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;


public class SignUpFragment extends Fragment {

    public SignUpFragment() {
        // Required empty public constructor
    }


    private TextView alreadyHaveAnAccount;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText fullName;
    private EditText password;
    private EditText confirmPassword;

    private ImageButton closeBtn;
    private Button signUpBtn;

    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private  String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        alreadyHaveAnAccount = view.findViewById(R.id.tv_already_have_an_account);

        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);
        email = view.findViewById(R.id.sign_in_email);
        fullName = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_up_fullname);
        confirmPassword = view.findViewById(R.id.sign_up_confirm_password);

        closeBtn = view.findViewById(R.id.sign_up_close_btn);
        signUpBtn = view.findViewById(R.id.sign_up_btn);

        progressBar = view.findViewById(R.id.sign_up_progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    // for the link of Have account or not
    @Override
    public void onViewCreated(View view, final Bundle savedInstancesState) {
        super.onViewCreated(view, savedInstancesState);
        alreadyHaveAnAccount.setOnClickListener((v) -> {
            setFragment(new SignInFragment());
        });
          closeBtn.setOnClickListener(v -> mainIntent());

        email.addTextChangedListener(new TextWatcher() {
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
        fullName.addTextChangedListener(new TextWatcher() {
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
        password.addTextChangedListener(new TextWatcher() {
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
        confirmPassword.addTextChangedListener(new TextWatcher() {
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

     signUpBtn.setOnClickListener(v ->

             checkEmailAndPassword());

    }


        private void setFragment(Fragment fragment) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_left);
            fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }

         private void checkInputs(){
                if(!TextUtils.isEmpty(email.getText())){
                    if(!TextUtils.isEmpty((fullName.getText()))){

                        if(!TextUtils.isEmpty(password.getText())&& password.length()>=8){

                            if(!TextUtils.isEmpty(confirmPassword.getText())){
                                signUpBtn.setEnabled(true);
                                signUpBtn.setTextColor(Color.argb(255,255,255,255));

                            }else{
                                //to do else of confirmPassword
                                signUpBtn.setEnabled(false);
                                signUpBtn.setTextColor(Color.argb(50,255,255,255));
                            }


                        }else{
                            //to do else of password
                            signUpBtn.setEnabled(false);
                            signUpBtn.setTextColor(Color.argb(50,255,255,255));
                        }

                    }else{
                        //to do else of fullname
                        signUpBtn.setEnabled(false);
                        signUpBtn.setTextColor(Color.argb(50,255,255,255));
                    }


                }else{
                    //to do else of checkInputs for email
                    signUpBtn.setEnabled(false);
                    signUpBtn.setTextColor(Color.argb(50,255,255,255));
                }
         }

         private void checkEmailAndPassword(){
          if(email.getText().toString().matches(emailPattern)){

              if(password.getText().toString().equals(confirmPassword.getText().toString())){

                  progressBar.setVisibility(View.VISIBLE);
                  signUpBtn.setEnabled(false);
                  signUpBtn.setTextColor(Color.argb(50,255,255,255));

                  firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                          .addOnCompleteListener(task -> {
                              if(task.isSuccessful()){
                                 mainIntent();
                              }else{
                                  //to do else of task.isSuccess()
                                  progressBar.setVisibility(View.VISIBLE);
                                  signUpBtn.setEnabled(true);
                                  signUpBtn.setTextColor(Color.argb(255,255,255,255));
                                  String error = task.getException().getMessage();
                                  Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                              }
                          });
              }else{
                  //to do else of password equals with confirm password
                  confirmPassword.setError("Password doesn't matched!");
              }
          }else{
              //to do else of email matches with mailPattern
              email.setError("Invalid Email ");
          }
       }
       private void mainIntent(){
           Intent mainIntent = new Intent(getActivity(),MainActivity.class);
           startActivity((mainIntent));
           getActivity().finish();
       }
    }
