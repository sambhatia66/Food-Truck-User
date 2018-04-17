package com.fluper.foodtruckuser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fluper on 10/4/18.
 */

public class SignUpModel {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("country_code")
    private String country_code;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("device_token")
    private String device_token;

    @SerializedName("device_type")
    private String device_type;

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public SignUpModel(String id, String name, String email, String country_code, String mobile,
                       String device_token, String device_type, String accessToken, String latitude
    , String longitude){

        this.id = id;
        this.name = name;
        this.email = email;
        this.country_code = country_code;
        this.mobile = mobile;
        this.device_token = device_token;
        this.device_type = device_type;
        this.accessToken = accessToken;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getDevice_type() {
        return device_type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
