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
import android.widget.Toolbar;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.KitchenAdapter;
import com.fluper.foodtruckuser.model.KitchenItems;

import java.util.ArrayList;

public class FilterListActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivDone;
    private ImageView ivBack;
    private RelativeLayout toolbar;
    private RecyclerView recyclerViewKitchen;
    KitchenAdapter kitchenAdapter;
    ArrayList<KitchenItems> kitchenItemsArrayList = new ArrayList<>();

    // todo make array external xml
    String[] KictenItemCategory = {"All Kitchen", "American", "Argentine", "BBQ", "Burgers",
            "Caribbean", "Ceviche", "Chinese","Colombian","French" , "Filipino", "Georgian",
            "Greek", "Hyderabad", "Indian","Indonasian", "Italian", "Japanese", "Kurdish",
            "Latian", "Maharashtrian", "Malasian", "Mexican", "Mordovian", "Parsi", "Persian",
            "Portuguese", "Punjabi", "Rajasthani", "Russian", "Serbian", "South Indian", "Spanish",
            "Sri Lankan", "Turkish","Ukrainian"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_list);

        initView();
        recyclerView();
        clickListeners();

    }

    private void initView() {

        toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.tv_header);
        ivBack = toolbar.findViewById(R.id.iv_back);
        ivDone = toolbar.findViewById(R.id.iv_done);
        recyclerViewKitchen = findViewById(R.id.recycler_kitchen);

    }

    private void recyclerView() {
        recyclerViewKitchen.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        int count = 0;
        for (String itemName : KictenItemCategory){
            kitchenItemsArrayList.add(new KitchenItems(itemName));
            count++;
        }
        kitchenAdapter = new KitchenAdapter(this, kitchenItemsArrayList);
        recyclerViewKitchen.setAdapter(kitchenAdapter);
    }
    @SuppressLint("SetTextI18n")
    private void clickListeners() {
        ivDone.setVisibility(View.VISIBLE);
        tvTitle.setText("Filter");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ivDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

}
