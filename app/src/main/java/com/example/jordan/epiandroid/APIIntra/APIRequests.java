package com.example.jordan.epiandroid.APIIntra;

import com.example.jordan.epiandroid.APIModels.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequests{

    @GET("/login")
    Call<Token> getToken(@Query("login") String login, @Query("password") String pass);
}
