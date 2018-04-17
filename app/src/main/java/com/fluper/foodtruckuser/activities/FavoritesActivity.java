package com.fluper.foodtruckuser.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.FoodItemsAdapter;
import com.fluper.foodtruckuser.model.FoodInformation;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends HomeActivity {

    private RelativeLayout toolbar;
    private RecyclerView recyclerViewFavorite;
    private TextView tvTitle;
    private ImageView ivBack;
    FoodItemsAdapter foodItemsAdapter;
    List<FoodInformation> foodtruckList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        initViews();
        recyclerView();
        clickListenes();
    }

    @SuppressLint("SetTextI18n")
    private void initViews() {
     toolbar = findViewById(R.id.toolbar);
     recyclerViewFavorite = findViewById(R.id.recycler_favorite);
     ivBack = findViewById(R.id.iv_back);
     tvTitle = toolbar.findViewById(R.id.tv_header);

     tvTitle.setText("Favorite");
    }

    private void recyclerView() {
        foodtruckList = listOfData();
        recyclerViewFavorite.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        foodItemsAdapter = new FoodItemsAdapter(this, foodTruckList);
        recyclerViewFavorite.setAdapter(foodItemsAdapter);

    }

    private void clickListenes() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
