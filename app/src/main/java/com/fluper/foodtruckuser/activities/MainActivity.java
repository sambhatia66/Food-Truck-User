package com.fluper.foodtruckuser.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.RegisterApi;
import com.fluper.foodtruckuser.model.SignInModel;
import com.fluper.foodtruckuser.rest.ApiClient;
import com.fluper.foodtruckuser.rest.ApiInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <H1>Food Truck SignUpModel</H1>
 * <H1>Main Activity</H1>
 * <p>Represents the main screen for user login</p>
 *
 * @author Satyam Bhatia
 * @version 1.0
 * @since 02/24/18
 */
public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnSignUp;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvForget;
    private String mEmail;
    private RelativeLayout relativeLayout;
    private String mPassword;
    private String mDeviceToken = "12345";
    private String mDeviceType = "0";
    private String mlatitude = "28.9848948";
    private String mlongitude = "22.3423223";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initControls();
    }


    private void init() {
        /*
          Represents the views of the activity.
         */
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvForget = findViewById(R.id.tv_forget);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_sign_up);
        relativeLayout = findViewById(R.id.relative_layout);

    }

    private boolean validateFields() {

        /*
          Represents the validation for the fields.
         */
        mEmail = etEmail.getText().toString().trim();
        mPassword = etPassword.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (TextUtils.isEmpty(mEmail) && TextUtils.isEmpty(mPassword)) {
            etEmail.setError("Enter email!");
            etPassword.setError("Enter password!");
            etEmail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mEmail)) {
            etEmail.setError("Enter email!");
            etEmail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mPassword)) {
            etPassword.setError("Enter password!");
            etPassword.requestFocus();
            return false;
        } else if (mPassword.length() < 8) {
            etPassword.setError("Password too short");
            etPassword.requestFocus();
            return false;
        } else if (!mEmail.matches(emailPattern)) {
            Toast.makeText(this, "Enter a valid email ", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    private void registerUsertoServer(String email, String password, String device_type,
                                      String device_token, String latitude, String longitude) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<RegisterApi> call = apiService.loginUser(email, password, device_type,
                device_token, latitude, longitude);
        call.enqueue(new Callback<RegisterApi>() {

            @Override
            public void onResponse(Call<RegisterApi> call, Response<RegisterApi> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_LONG).show();
                    RegisterApi registerApi = response.body();
                    String message = registerApi.message;
                    if (message != null) {
                        Toast.makeText(MainActivity.this, "" + message, Toast.LENGTH_LONG).show();
                        RegisterApi registerApi1 = response.body();
                        SignInModel signInModel = registerApi1.signInModel;
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        finish();
                        // Intent intent = new Intent(ExplorerSignUpActivity.this, IntroSlideActivity.class);
                        // intent.putExtra("STATUS", value);
                        // startActivity(intent);
                    } else
                        Toast.makeText(MainActivity.this, "Registration Fails", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Toast.makeText(MainActivity.this, "" + response.errorBody().string(), Toast.LENGTH_LONG).show();
                        Log.d("TEST", "Error : " + response.errorBody().string() + "message : " + response.message());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onFailure(retrofit2.Call<RegisterApi> call, Throwable t) {

                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
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

    private void initControls() {

        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgetPasswordActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    registerUsertoServer(mEmail, mPassword, mDeviceType, mDeviceToken, mlatitude, mlongitude);
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleNotification();
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

    }

    private void simpleNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "cancel");
        builder.setContentTitle("Notification");
        builder.setContentText("Please sign up.");
        builder.setSmallIcon(R.drawable.bell_red);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(12, notification);
        }

    }

}
