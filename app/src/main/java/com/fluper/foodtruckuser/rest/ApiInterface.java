package com.fluper.foodtruckuser.rest;


import com.fluper.foodtruckuser.model.RegisterApi;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Satyam on 3/12/2018.
 */

public interface ApiInterface {
    @POST("register")
    Call<RegisterApi> registerUser(@Query("email") String email ,
                                   @Query("password") String password);


}
