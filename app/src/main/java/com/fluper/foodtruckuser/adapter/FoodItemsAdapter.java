package com.fluper.foodtruckuser.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.FoodInformation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 27/3/18.
 */

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemsAdapter.MyViewHolder> {
    Context context;
    private List<FoodInformation> foodTruckList = new ArrayList<>();
    FoodInformation foodInformation;


    public FoodItemsAdapter(Context context, List<FoodInformation> foodTruckList) {
        this.context = context;
        this.foodTruckList = foodTruckList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_singleitem_home, parent,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        foodInformation = foodTruckList.get(position);
        holder.ivFood.setImageResource(foodInformation.getFoodImage());
        holder.tvTruckName.setText(foodInformation.getTruckName());
        holder.tvTruckLocation.setText("Peruvian, Burgers");
        holder.civTruck.setImageResource(foodInformation.getTruckImage());
        holder.rbRatings.setRating(3.5f);


    }

    @Override
    public int getItemCount() {

        return foodTruckList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFood;
        CircleImageView civTruck;
        TextView tvTruckName;
        TextView tvTruckLocation;
        RatingBar rbRatings;
        CheckBox checkBoxFavorite;


        public MyViewHolder(View itemView) {
            super(itemView);
            ivFood = itemView.findViewById(R.id.iv_food);
            civTruck = itemView.findViewById(R.id.civ_truck);
            tvTruckName = itemView.findViewById(R.id.tv_truck_name);
            tvTruckLocation = itemView.findViewById(R.id.tv_truck_location);
            rbRatings = itemView.findViewById(R.id.rating_bar_truck);
            checkBoxFavorite = itemView.findViewById(R.id.check_box_favorite);

        }

    }


    //method for filter the foodtruck names.

    public void setfilter(ArrayList<FoodInformation> newList) {
        foodTruckList = new ArrayList<>();
        foodTruckList.addAll(newList);
        notifyDataSetChanged();
    }


}
