package com.fluper.foodtruckuser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Satyam on 3/12/2018.
 */

public class RegisterApi {

    @SerializedName("message")
    public String message;

    @SerializedName("result")
    public SignUpModel signUpModelModel;
    public SignInModel signInModel;




    }

