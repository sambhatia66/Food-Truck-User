package com.fluper.foodtruckuser.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fluper.foodtruckuser.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText etEmail;
    private ImageView ivBack;
    private RelativeLayout toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        initViews();
        initClick();
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
                String email = etEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Enter email");
                    etEmail.requestFocus();
                    return;
                } else
                    startActivity(new Intent(ForgetPasswordActivity.this, OTPActivity.class));
            }
        });
    }

    private void initViews() {
        btnNext = findViewById(R.id.btn_next);
        etEmail = findViewById(R.id.et_email);
        toolbar = findViewById(R.id.toolbar);
        ivBack = toolbar.findViewById(R.id.iv_back);
    }
}
