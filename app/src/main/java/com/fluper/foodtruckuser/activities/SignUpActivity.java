package com.fluper.foodtruckuser.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.RegisterApi;
import com.fluper.foodtruckuser.model.SignUpModel;
import com.fluper.foodtruckuser.rest.ApiClient;
import com.fluper.foodtruckuser.rest.ApiInterface;
import com.hbb20.CountryCodePicker;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText etFullName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnSignUp;
    private Button btnCheckIn;
    private TextView tvTermsAndConditions;
    private CheckBox checkBox;
    private CountryCodePicker countryCodePicker;
    private RelativeLayout relativeLayout;
    String mName;
    String mEmail;
    String mCountryCode;
    String mPhone;
    String mPassword;
    String mDeviceToken = "1234567";
    String mDeviceType = "0";
    String mlatitude = "28.9848948";
    String mlongitude = "22.3423223";

    /*AppUtils appUtils;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail = findViewById(R.id.et_email);
        initViews();
        initClick();
    }

    private void initViews() {
        relativeLayout = findViewById(R.id.relative_layout);
        etFullName = findViewById(R.id.et_sign_up_full_name);
        etPhone = findViewById(R.id.et_sign_up_phone_no);
        etPassword = findViewById(R.id.et_sign_up_password);
        etConfirmPassword = findViewById(R.id.et_sign_up_confirm_password);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnCheckIn = findViewById(R.id.btn_check_in);
        tvTermsAndConditions = findViewById(R.id.tv_terms_conditions);
        checkBox = findViewById(R.id.check_box);
        countryCodePicker = findViewById(R.id.country_code);
    }

    private void initClick() {
        tvTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, TermsAndConditionsActivity.class));
                finish();
            }
        });
        checkBox.setChecked(true);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    if (checkBox.isChecked()) {
                        if (isOnline()) {
                            registerUsertoServer(mName, mEmail, mCountryCode, mPhone, mPassword,
                                    mDeviceToken, mDeviceType, mlatitude, mlongitude);
                        }
                    }
                }
            }
        });

        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                finishAffinity();
            }
        });

        countryCodePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryCodePicker.getSelectedCountryCode();
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            final Snackbar snackbar = Snackbar.make(relativeLayout,
                    "No internet connection!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            sbView.setAlpha(0.6f);
            TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
            return false;
        }
        return true;
    }

    public boolean validateFields() {
        mName = etFullName.getText().toString().trim();
        mEmail = etEmail.getText().toString().trim();
        mCountryCode = countryCodePicker.getSelectedCountryCodeWithPlus();
        mPhone = etPhone.getText().toString().trim();
        mPassword = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (TextUtils.isEmpty(mEmail)
                && TextUtils.isEmpty(mName)
                && TextUtils.isEmpty(mPhone)
                && TextUtils.isEmpty(mPassword)
                && TextUtils.isEmpty(confirmPassword)) {
            etEmail.setError("Enter Email");
            etFullName.setError("Enter Name");
            etPhone.setError("Enter PhoneNo.");
            etPassword.setError("Enter Password");
            etConfirmPassword.setError("Enter Password");
            etFullName.requestFocus();
            return false;

        } else if (TextUtils.isEmpty(mName)) {
            etEmail.setError("Enter full name");
            etEmail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mEmail)) {
            etEmail.setError("Enter email");
            etEmail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mPhone)) {
            etPhone.setError("Enter phone no.");
            etPhone.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mPassword)) {
            etPassword.setError("Enter password");
            etPassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setError("Confirm password");
            etConfirmPassword.requestFocus();
            return false;
        } else if (mPassword.length() < 8) {
            etPassword.setError("Password too short");
            etPassword.requestFocus();
            return false;
        } else if (!mPassword.equals(confirmPassword)) {
            Toast.makeText(SignUpActivity.this, "Passwords are not matching",
                    Toast.LENGTH_SHORT).show();
        } else if (!mEmail.matches(emailPattern)) {
            Toast.makeText(SignUpActivity.this, "Enter a valid email!",
                    Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    private void registerUsertoServer(String name, String email, String country_code,
                                      String mobile, String password, String device_token,
                                      String device_type, String latitude, String longitude) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<RegisterApi> call = apiService.registerUser(name, email, country_code, mobile,
                password, device_token, device_type, latitude, longitude);
        call.enqueue(new Callback<RegisterApi>() {

            @Override
            public void onResponse(Call<RegisterApi> call, Response<RegisterApi> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "successful", Toast.LENGTH_LONG).show();
                    RegisterApi registerApi = response.body();
                    String message = registerApi.message;
                    if (message != null) {
                        Toast.makeText(SignUpActivity.this, "" + message, Toast.LENGTH_LONG).show();
                        RegisterApi registerApi1 = response.body();
                        SignUpModel signUpModelModel = registerApi1.signUpModelModel;

                        startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                        finish();
                        // Intent intent = new Intent(ExplorerSignUpActivity.this, IntroSlideActivity.class);
                        // intent.putExtra("STATUS", value);
                        // startActivity(intent);
                    } else
                        Toast.makeText(SignUpActivity.this, "Registration Fails", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Toast.makeText(SignUpActivity.this, "" + response.errorBody().string(), Toast.LENGTH_LONG).show();
                        Log.d("TEST", "Error : " + response.errorBody().string() + "message : " + response.message());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onFailure(retrofit2.Call<RegisterApi> call, Throwable t) {

                Toast.makeText(SignUpActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
