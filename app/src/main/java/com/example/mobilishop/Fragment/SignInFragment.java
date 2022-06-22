package com.example.mobilishop.Fragment;

import static com.example.mobilishop.Activity.RegisterActivity.onResetPasswordFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilishop.Activity.MainActivity;
import com.example.mobilishop.API.ServiceGeneratorApi;
import com.example.mobilishop.R;
import com.google.firebase.auth.FirebaseAuth;


public class SignInFragment extends Fragment {


    public SignInFragment() {
        // Required empty public constructor
    }


    private TextView dontHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private EditText email;
    private  EditText password;

    private ProgressBar progressBar;

    private TextView forgotPassword;

    private ImageButton closeBtn;
    private Button signInBtn;
    private FirebaseAuth firebaseAuth;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    public void signIn(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAccount = view.findViewById(R.id.tv_dont_have_an_account);

        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);
        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_in_password);

        forgotPassword = view.findViewById(R.id.sign_in_forgot_password);

        progressBar = view.findViewById(R.id.sign_in_progressbar);

        closeBtn = view.findViewById(R.id.sign_in_close_btn);

        signInBtn = view.findViewById(R.id.sign_in_btn);

        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@Nullable View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener((v)->{
            setFragment(new SignUpFragment());
        });

        forgotPassword.setOnClickListener((v) ->{
            onResetPasswordFragment = true;
            setFragment(new ResetPasswordFragment());
                });
        //to do btn to close
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
        signInBtn.setOnClickListener(v -> checkEmailAndPassword());
    }




    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_left);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(password.getText())){

                signInBtn.setEnabled(true);
                signInBtn.setTextColor(Color.argb(255,255,255,255));

            }else{
                //to do else of password
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(55,255,255,255));

            }


        }else{
            //to do else of email
            signInBtn.setEnabled(false);
            signInBtn.setTextColor(Color.argb(55,255,255,255));

        }
    }
    private void checkEmailAndPassword() {
        if(email.getText().toString().matches(emailPattern)){

            if(password.length()>=8){

                progressBar.setVisibility(View.VISIBLE);
                signInBtn.setEnabled(true);
                signInBtn.setTextColor(Color.argb(255,255,255,255));

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()){

                              mainIntent();

                            }else{
                                //to do else of email and password of firebaseAuth

                                progressBar.setVisibility(View.INVISIBLE);
                                signInBtn.setEnabled(false);
                                signInBtn.setTextColor(Color.argb(255,255,255,255));
                                String error = task.getException().getMessage();
                                Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                            }
                        });

            }else{
                // to do else of password
                Toast.makeText(getActivity(),"Incorrect email or password",Toast.LENGTH_SHORT).show();

            }
        }else{
             //to do else of email and pattern
            Toast.makeText(getActivity(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
        }
    }
    public interface ApiService{
        void onResponse(ServiceGeneratorApi generatorApi);
        void onFailure(Throwable throwable);

    }
    private void mainIntent(){
        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}