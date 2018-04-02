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
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;

public class NewPasswordActivity extends AppCompatActivity {

    private EditText etNewPassword;
    private EditText etConfirmNewPassword;
    private Button btnSubmit;
    private RelativeLayout toolbar;
    private TextView header;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        initViews();
        initClick();
        header.setText("Enter new password");

    }

    private void initClick() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = etNewPassword.getText().toString().trim();
                String confirmPassword = etConfirmNewPassword.getText().toString().trim();
                if (TextUtils.isEmpty(newPassword) && TextUtils.isEmpty(confirmPassword)) {
                    etNewPassword.setError("Enter new Password");
                    etConfirmNewPassword.setError("Confirm new Password");
                    etNewPassword.requestFocus();
                    return;
                }
                if ((newPassword.length() < 8) && (confirmPassword.length() < 8)) {
                    Toast.makeText(NewPasswordActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((newPassword.equals(confirmPassword))) {
                    startActivity(new Intent(NewPasswordActivity.this, MainActivity.class));
                    finishAffinity();
                    return;
                } else
                    Toast.makeText(NewPasswordActivity.this, "Password not matched", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {

        etNewPassword = findViewById(R.id.et_new_password);
        etConfirmNewPassword = findViewById(R.id.et_confirm_new_password);
        btnSubmit = findViewById(R.id.btn_submit);
        toolbar = findViewById(R.id.toolbar);
        header = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);

    }
}
