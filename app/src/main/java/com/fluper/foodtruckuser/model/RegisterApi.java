package com.fluper.foodtruckuser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Satyam on 3/12/2018.
 */

public class RegisterApi {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
