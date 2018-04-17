package com.fluper.foodtruckuser.activities;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.FoodItemsAdapter;
import com.fluper.foodtruckuser.adapter.MenuItemAdapter;
import com.fluper.foodtruckuser.adapter.ViewPagerAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodTruckDetailActivity extends AppCompatActivity {

    private RelativeLayout toolbar;
    private ImageView ivFoodImage;
    private CircleImageView civTruckImage;
    private TextView tvTitle;
    private ImageView ivCart;
    private RatingBar ratingBar;
    private CheckBox checkBoxFavorite;
    private RelativeLayout rl_book;
    private ImageView ivBack;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck_detail);
        initViews();
        getDataFromIntent();
        setFragmentOnViewPager();
        clickListener();



    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);
        ivCart = toolbar.findViewById(R.id.iv_cart);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        ivFoodImage = findViewById(R.id.iv_food);
        civTruckImage = findViewById(R.id.civ_truck);




        ivCart.setVisibility(View.VISIBLE);

    }
    private void getDataFromIntent() {
        String truckName = getIntent().getStringExtra("TRUCK-NAME");
        int truckImage = getIntent().getIntExtra("TRUCK-IMAGE", 0);
        int foodImage = getIntent().getIntExtra("FOOD-IMAGE", 0);


        tvTitle.setText(truckName);
        civTruckImage.setImageResource(truckImage);
        ivFoodImage.setImageResource(foodImage);


    }

    private void setFragmentOnViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addfragment(new MenuFragment(), "Menu");
        viewPagerAdapter.addfragment(new AboutFragment(), "About");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }


    private void clickListener() {
        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });

    }
}

