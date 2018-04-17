package com.fluper.foodtruckuser.rest;


import com.fluper.foodtruckuser.model.RegisterApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Satyam on 3/12/2018.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("customerRegistration")
    Call<RegisterApi> registerUser(@Field("name") String name,
                                   @Field("email") String email,
                                   @Field("country_code") String country_code,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("device_token") String device_token,
                                   @Field("device_type") String device_type,
                                   @Field("latitude") String latitude,
                                   @Field("longitude") String longitude);

    @FormUrlEncoded
    @POST("customerLogin")
    Call<RegisterApi> loginUser(@Field("email") String email,
                                   @Field("password") String password,
                                   @Field("device_type") String device_type,
                                   @Field("device_token") String device_token,
                                   @Field("latitude") String latitude,
                                   @Field("longitude") String longitude);

}
