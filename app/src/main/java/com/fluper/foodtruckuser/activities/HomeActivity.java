package com.fluper.foodtruckuser.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.FoodItemsAdapter;
import com.fluper.foodtruckuser.model.FoodInformation;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private CircleImageView civProfile;
    private ImageView ivMap;
    private ImageView ivCart;
    private EditText etSearch;
    private RecyclerView rvFoodList;
    private RelativeLayout rlFilter;
    // todo restrict scopes...
    // todo minimeze upto 99% lints warning...
    FoodItemsAdapter foodItemsAdapter;
    List<FoodInformation> foodTruckList = new ArrayList<>();
    FoodInformation foodInformation;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;


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

    public List<FoodInformation> listOfData() {

        List<FoodInformation> data = new ArrayList<>();

        data.add(new FoodInformation(R.drawable.truck_one, "Croquettes"
                , R.drawable.food_fifteen));
        data.add(new FoodInformation(R.drawable.truck_two, "Tortilla Espanola"
                , R.drawable.food_eleven));
        data.add(new FoodInformation(R.drawable.truck_three, "Pulpo a la gallega"
                , R.drawable.food_ten));
        data.add(new FoodInformation(R.drawable.truck_four, "Spain's famous bean stews – and salads"
                , R.drawable.food_sixteen));
        data.add(new FoodInformation(R.drawable.truck_five, "Paella"
                , R.drawable.food_two));
        data.add(new FoodInformation(R.drawable.truck_six, "Fried milk"
                , R.drawable.food_thirteen));
        data.add(new FoodInformation(R.drawable.truck_seven, "Prawns in fried garlic"
                , R.drawable.food_six));
        data.add(new FoodInformation(R.drawable.truck_eight, "Gazpacho or salmorejo"
                , R.drawable.food_seventeen));
        data.add(new FoodInformation(R.drawable.truck_one, "Pisto – Spanish ratatouille"
                , R.drawable.food_one));


        return data;
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
                if (checkLocationPermission())
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
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());
            }
        });

        rvFoodList.addOnItemTouchListener(new RecyclerTouchListener(this, rvFoodList, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                FoodInformation foodInformation = foodTruckList.get(position);
                String truckName = foodInformation.getTruckName();
                int truckImage = foodInformation.getTruckImage();
                int foodImage = foodInformation.getFoodImage();

                Intent foodIntent = new Intent(HomeActivity.this, FoodTruckDetailActivity.class);
                foodIntent.putExtra("TRUCK-NAME", truckName);
                foodIntent.putExtra("TRUCK-IMAGE", truckImage);
                foodIntent.putExtra("FOOD-IMAGE", foodImage);
                startActivity(foodIntent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    private void filter(String newText) {

        newText = newText.toLowerCase();
        ArrayList<FoodInformation> newList = new ArrayList<>();
        for (FoodInformation truckName : foodTruckList) {

            String nameTruck = truckName.getTruckName().toLowerCase();
            if (nameTruck.contains(newText))
                newList.add(truckName);
        }
        foodItemsAdapter.setfilter(newList);
    }

    private void recyclerView() {
        foodTruckList = listOfData();
        rvFoodList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        foodItemsAdapter = new FoodItemsAdapter(this, foodTruckList);
        rvFoodList.setAdapter(foodItemsAdapter);
    }

    //Check Location Permission for application.
    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Permissions")
                        .setMessage("Give map permission to app!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(HomeActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                    startActivity(new Intent(HomeActivity.this, MapsActivity.class));
                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:

//                        String provider = locationManager.getBestProvider(new Criteria(),
//                                false);
//
//                        locationManager.requestLocationUpdates(provider, 400,
//                                1, (LocationListener) this);

                        startActivity(new Intent(HomeActivity.this, MapsActivity.class));
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    new AlertDialog.Builder(this)
                            .setTitle("Need Permission")
                            .setMessage("This app need location permission")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                            Uri.parse("package:" + getPackageName()));
                                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                            }).create().show();

                }
            }

        }
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        RecyclerTouchListener(Context context, final RecyclerView recycleView,
                              final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
