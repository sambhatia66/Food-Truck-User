package com.fluper.foodtruckuser.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.RegisterApi;
import com.fluper.foodtruckuser.rest.ApiClient;
import com.fluper.foodtruckuser.rest.ApiInterface;

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
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail = findViewById(R.id.et_email);
        initViews();
        initClick();
    }
    private void initViews() {
        etFullName = findViewById(R.id.et_sign_up_full_name);
        etPhone = findViewById(R.id.et_sign_up_phone_no);
        etPassword = findViewById(R.id.et_sign_up_password);
        etConfirmPassword = findViewById(R.id.et_sign_up_confirm_password);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnCheckIn = findViewById(R.id.btn_check_in);
    }

    private void initClick() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()){
                    registerUsertoServer(email,password);
                    startActivity(new Intent(SignUpActivity.this , MainActivity.class));
                    finish();
                }
            }


            public boolean validateFields(){
                email = etEmail.getText().toString().trim();
                String fullName = etFullName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)
                        && TextUtils.isEmpty(fullName)
                        && TextUtils.isEmpty(phone)
                        && TextUtils.isEmpty(password)
                        && TextUtils.isEmpty(confirmPassword)) {
                    etEmail.setError("Enter Email");
                    etFullName.setError("Enter Name");
                    etPhone.setError("Enter PhoneNo.");
                    etPassword.setError("Enter Password");
                    etConfirmPassword.setError("Enter Password");
                    etFullName.requestFocus();
                    return false;

                }
                if (TextUtils.isEmpty(fullName)) {
                    etEmail.setError("Enter full name");
                    etEmail.requestFocus();
                    return false;
                }
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Enter email");
                    etEmail.requestFocus();
                    return false;
                }
                if (TextUtils.isEmpty(phone)) {
                    etPhone.setError("Enter phone no.");
                    etPhone.requestFocus();
                    return false;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Enter password");
                    etPassword.requestFocus();
                    return false;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Confirm password");
                    etConfirmPassword.requestFocus();
                    return false;
                }
                if (password.length() < 8) {
                    etPassword.setError("Password too short");
                    etPassword.requestFocus();
                    return false;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Passwords are not matching",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                finishAffinity();
            }
        });
    }

    private void registerUsertoServer(String email,String password) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<RegisterApi> call = apiService.registerUser(email,password);
        call.enqueue(new Callback<RegisterApi>() {

            @Override
            public void onResponse(Call<RegisterApi> call, Response<RegisterApi> response) {
                Toast.makeText(SignUpActivity.this, "done", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(retrofit2.Call<RegisterApi> call, Throwable t) {

                Toast.makeText(SignUpActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
