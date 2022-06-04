package com.example.mobilishop.API;
import com.example.mobilishop.API.ApiService;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class GeneratorApi {
  private static Retrofit getRetrofit(){
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("http://localhost:8080/api/v1")
              .addConverterFactory(GsonConverterFactory.create())
              .build();
      return retrofit;
  }
  public static ApiService getApiService(){
      ApiService apiService = getRetrofit().create(ApiService.class);
      return apiService;
  }
}
