package com.example.mobilishop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Generator {
    private static final String BASE_URL= "http://localhost:8080/api/v1";

    public static void main(String[] args){
        System.out.println( BASE_URL );
        /*
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

         */
    }



}
