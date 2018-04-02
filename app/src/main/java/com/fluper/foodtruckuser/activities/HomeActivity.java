package com.fluper.foodtruckuser.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.FoodItemsAdapter;
import com.fluper.foodtruckuser.model.FoodInformation;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private CircleImageView civProfile;
    private ImageView ivMap;
    private ImageView ivCart;
    private EditText etSearch;
    private RecyclerView rvFoodList;
    private RelativeLayout rlFilter;
    FoodItemsAdapter foodItemsAdapter;
    ArrayList<FoodInformation> foodTruckList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        clickListeners();
        recyclerView();

    }

    private void initViews() {
        civProfile = findViewById(R.id.civ_profile);
        ivMap = findViewById(R.id.iv_map);
        ivCart = findViewById(R.id.iv_cart);
        etSearch = findViewById(R.id.et_search);
        rvFoodList = findViewById(R.id.rv_food_list);
        rlFilter = findViewById(R.id.rl_filter);
    }


    private void clickListeners() {
        civProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));
            }
        });
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MapsActivity.class));
            }
        });
        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CartActivity.class));
            }
        });
        rlFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FilterListActivity.class));
            }
        });

    }
    private void recyclerView() {
        rvFoodList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        foodItemsAdapter = new FoodItemsAdapter(this, foodTruckList);
        rvFoodList.setAdapter(foodItemsAdapter);

    }

}
