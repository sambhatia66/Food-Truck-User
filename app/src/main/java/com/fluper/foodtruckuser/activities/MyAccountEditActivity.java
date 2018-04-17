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
import android.widget.Toast;

import com.fluper.foodtruckuser.R;

public class MyAccountEditActivity extends AppCompatActivity {

    private RelativeLayout toolbar;
    private TextView tvTitle;
    private ImageView ivBack;
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPhone;
    private Button btnSave;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_edit);
        initViews();
        clickListener();
        tvTitle.setText("My Account");
    }
    private void validateFields() {

        /**
         * Represents the validation for the fields.
         */
        String name = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (TextUtils.isEmpty(name)) {
            etFullName.setError("Enter full name!");
            etFullName.requestFocus();
            return;
        }

        else if (TextUtils.isEmpty(email)) {
            etEmail.setError("Enter email!");
            etEmail.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Enter phone no.!");
            etPhone.requestFocus();
            return;
        }
        else if (phone.length() < 8) {
            etPhone.setError("Invalid phone no.");
            etPhone.requestFocus();
            return;
        }
        if (email.matches(emailPattern)){
            startActivity(new Intent(MyAccountEditActivity.this, MyAccountActivity.class));
            finish();
        }else
            Toast.makeText(this, "Enter a valid email!", Toast.LENGTH_SHORT).show();

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);
        etFullName = findViewById(R.id.et_full_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone_no);
        btnSave = findViewById(R.id.btn_save);
    }

    private void clickListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }
}
