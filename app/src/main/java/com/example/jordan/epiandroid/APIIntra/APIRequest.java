package com.example.jordan.epiandroid.APIIntra;


import com.example.jordan.epiandroid.Models.DashBoard.DashInfos;
import com.example.jordan.epiandroid.Models.Login.Token;
import com.example.jordan.epiandroid.Models.ModulesMarks.AllModules;
import com.example.jordan.epiandroid.Models.ModulesMarks.Marks;
import com.example.jordan.epiandroid.Models.ModulesMarks.Modules;
import com.example.jordan.epiandroid.Models.Planning.Activity;
import com.example.jordan.epiandroid.Models.Profile.UserProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {

    @GET("/login")
    Call<Token> getToken(@Query("login") String login, @Query("password") String pass);

    @GET("/infos")
    Call<DashInfos> getInfos(@Query("token") String token);

    @GET("/user")
    Call<UserProfile> getUser(@Query("token") String token, @Query("user") String user);

    @GET("/planning")
    Call<List<Activity>> getPlanning(@Query("token") String token, @Query("start") String start,
                                     @Query("end") String end);

    @GET("/allmodules")
    Call<AllModules> getAllModules(@Query("token") String token, @Query("scolaryear") String scolarYear,
                                   @Query("location") String location, @Query("course") String course);

    @GET("/modules")
    Call<Modules> getModules(@Query("token") String token);

    @GET("/marks")
    Call<Marks> getMarks(@Query("token") String token);

    @GET("/token")
    Call<com.example.jordan.epiandroid.Models.Token.Token> postToken(@Query("token") String token, @Query("scolaryear") String scolaryear,
                                                                     @Query("codemodule") String codemodule, @Query("codeinstance") String codeinstance,
                                                                     @Query("codeacti") String codeacti, @Query("codeevent") String codeevent,
                                                                     @Query("tokenvalidationcode") String tokenvalidationcode);
}