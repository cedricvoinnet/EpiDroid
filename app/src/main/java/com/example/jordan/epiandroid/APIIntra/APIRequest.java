package com.example.jordan.epiandroid.APIIntra;


import com.example.jordan.epiandroid.Model.DashInfos;
import com.example.jordan.epiandroid.Model.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest{

    @GET("/login")
    Call<Token> getToken(@Query("login") String login, @Query("password") String pass);

    @GET("/infos")
    Call<DashInfos> getInfos(@Query("token") String token);
}