package com.fluper.foodtruckuser.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fluper on 11/4/18.
 */

public class SignInModel {
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

    @SerializedName("profile_image")
    private String profile_image;

    @SerializedName("forgot_password_otp")
    private String forgot_password_otp;

   @SerializedName("is_block")
    private String is_block;


    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("device_token")
    private String device_token;

    @SerializedName("device_type")
    private String device_type;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("deleted_at")
    private String deleted_at;

    @SerializedName("customer_image_original")
    private String customer_image_original;

    @SerializedName("customer_image_medium")
    private String customer_image_medium;

    @SerializedName("customer_image_small")
    private String customer_image_small;

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

    public String getProfile_image() {
        return profile_image;
    }

    public String getForgot_password_otp() {
        return forgot_password_otp;
    }

    public String getIs_block() {
        return is_block;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getDevice_type() {
        return device_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public String getCustomer_image_original() {
        return customer_image_original;
    }

    public String getCustomer_image_medium() {
        return customer_image_medium;
    }

    public String getCustomer_image_small() {
        return customer_image_small;
    }

}
