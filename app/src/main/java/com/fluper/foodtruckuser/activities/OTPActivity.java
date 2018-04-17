package com.fluper.foodtruckuser.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;

public class OTPActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText etOtp;
    private RelativeLayout toolbar;
    private TextView header;
    private ImageView ivBack;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initViews();
        initClick();
        header.setText("Enter OTP");
    }

    private void initViews() {

        etOtp = findViewById(R.id.et_otp);
        btnNext = findViewById(R.id.btn_next);
        toolbar = findViewById(R.id.toolbar);
        header = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);
    }

    private void initClick() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = etOtp.getText().toString().trim();
                if (TextUtils.isEmpty(otp)) {
                    etOtp.setError("Enter OTP");
                    return;
                }
                if (otp.length()< 4){
                    etOtp.setError("Invalid OTP!");
                }else
                    startActivity(new Intent(OTPActivity.this, NewPasswordActivity.class));
            }
        });

    }
}
