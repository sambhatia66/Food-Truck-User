package com.fluper.foodtruckuser.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fluper.foodtruckuser.R;

// todo create base activitry base fragment....
public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        init();
        initControl();
    }

    // todo setup init and init control follow the pattern
    private void initControl() {
    }

    private void init() {

    }
}
