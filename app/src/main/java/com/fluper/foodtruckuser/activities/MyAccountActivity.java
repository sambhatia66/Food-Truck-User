package com.fluper.foodtruckuser.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAccountActivity extends AppCompatActivity {

    private RelativeLayout toolbar;
    private ImageView ivBack;
    private TextView tvTitle;
    private CircleImageView civUserProfile;
    private CircleImageView civEdit;
    private TextView tvName;
    private TextView tvEmail;
    private LinearLayout layoutOrderHistory;
    private LinearLayout layoutReverseHistory;
    private LinearLayout layoutFeedback;
    private LinearLayout layoutSupport;
    private TextView tvFavorites;
    private Switch switchNotification;
    private TextView tvChangePassword;
    private Button btnDisconnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        initViews();
        clickListeners();
        tvTitle.setText("My Account");
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        ivBack = toolbar.findViewById(R.id.iv_back);
        tvTitle = toolbar.findViewById(R.id.tv_header);
        civUserProfile = findViewById(R.id.civ_user_profile);
        civEdit = findViewById(R.id.civ_edit);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        layoutOrderHistory = findViewById(R.id.layout_order_history);
        layoutReverseHistory = findViewById(R.id.layout_reverse_history);
        layoutFeedback = findViewById(R.id.layout_feedback);
        layoutSupport = findViewById(R.id.layout_support);
        tvFavorites = findViewById(R.id.tv_favorites);
        tvChangePassword = findViewById(R.id.tv_change_password);
        switchNotification = findViewById(R.id.switch_notification);
        btnDisconnect = findViewById(R.id.btn_disconnect);
    }

    private void clickListeners() {

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        civEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, MyAccountEditActivity.class));
            }
        });
        layoutOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, OrderHistoryActivity.class));
            }
        });
        layoutReverseHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, ReverseHistoryActivity.class));
            }
        });
        tvFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, FavoritesActivity.class));
            }
        });
        tvChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, ChangePasswordActivity.class));
            }
        });
        btnDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccountActivity.this, MainActivity.class));
                finishAffinity();
            }
        });

    }

}
