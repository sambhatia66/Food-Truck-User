package com.fluper.foodtruckuser.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;

public class TermsAndConditionsActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivBack;
    private RelativeLayout toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        initViews();
        clickListeners();
    }

    @SuppressLint("SetTextI18n")
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);

        tvTitle.setText("Terms And Conditions");
    }

    private void clickListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
