package com.fluper.foodtruckuser.rest;
import com.fluper.foodtruckuser.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Satyam on 3/12/2018.
 */

public class ApiClient {


    // todo seprate this into constants...
        public static final String BASE_URL = "http://18.221.126.139/foodTruck/api/customer/";
        private static Retrofit retrofit = null;


        // todo where is singleton object...
    public static Retrofit getClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
        httpClient.writeTimeout (60, TimeUnit.SECONDS);


        // add logging as last interceptor only in Development Mode.
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(logging);
        }


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}

