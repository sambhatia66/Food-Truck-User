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

public class ChangePasswordActivity extends AppCompatActivity {

    private RelativeLayout toolbar;
    private ImageView ivBack;
    private TextView tvTitle;
    private EditText etInternalPassword;
    private EditText etNewPassword;
    private EditText etConfirmNewPAssword;
    private Button btnSave;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initViews();
        clickListeners();
        tvTitle.setText("Change Password");
    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        ivBack = toolbar.findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_header);
        etInternalPassword = findViewById(R.id.et_internal_password);
        etNewPassword = findViewById(R.id.et_new_password);
        etConfirmNewPAssword = findViewById(R.id.et_confirm_new_password);
        btnSave = findViewById(R.id.btn_save);
    }

    private void validateFields() {

        /*
          Represents the validation for the fields.
         */
        String internalPassword = etInternalPassword.getText().toString().trim();
        String newPassword = etNewPassword.getText().toString().trim();
        String confirmNewPassword = etConfirmNewPAssword.getText().toString().trim();

        if (TextUtils.isEmpty(internalPassword)) {
            etInternalPassword.setError("Enter internal password!");
            etInternalPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(newPassword)) {
            etNewPassword.setError("Enter new password!");
            etNewPassword.requestFocus();
            return;
        }
        // todo maitain RTL...
        // todo externalize all string at one go...
        if (TextUtils.isEmpty(confirmNewPassword)) {
            etConfirmNewPAssword.setError("Re-enter new password!");
            etConfirmNewPAssword.requestFocus();
            return;
        }
        if (newPassword.length() < 8) {
            etNewPassword.setError("password too short!");
            etNewPassword.requestFocus();
            return;
        }
        if (confirmNewPassword.equals(newPassword)) {
            startActivity(new Intent(ChangePasswordActivity.this, MyAccountActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Password fields not matches", Toast.LENGTH_SHORT).show();

        }
    }


    private void clickListeners() {
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
