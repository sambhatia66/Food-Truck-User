package com.fluper.foodtruckuser.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;

/**
 * <H1>Food Truck User</H1>
 * <H1>Main Activity</H1>
 * <p>Represents the main screen for user login and sign up<br>
 * User can log in as well as sign up</p>
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initClick();
    }


    private void initViews() {
        /**
         * Represents the views of the activity.
         */
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvForget = findViewById(R.id.tv_forget);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_sign_up);

    }

    private void validateFields() {

        /**
         * Represents the validation for the fields.
         */
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            etEmail.setError("Enter email!");
            etPassword.setError("Enter password!");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Enter email!");
            etEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Enter password!");
            etPassword.requestFocus();
            return;
        }
        if (password.length() < 8) {
            etPassword.setError("Password too short");
            etPassword.requestFocus();
            return;
        }
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();
    }

    private void initClick() {

        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgetPasswordActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();

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
        manager.notify(12, notification);

    }

}
