package com.fluper.foodtruckuser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.FoodInformation;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 27/3/18.
 */

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemsAdapter.MyViewHolder> {
    Context context;
    ArrayList<FoodInformation> foodTruckList = new ArrayList<>();


    public FoodItemsAdapter(Context context, ArrayList<FoodInformation> foodTruckList) {
        this.context = context;
        this.foodTruckList = foodTruckList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_singleitem_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.ivFood.setImageResource(R.drawable.main_list_item);
        holder.tvTruckName.setText("Matilde's Recipe");
        holder.tvTruckLocation.setText("Peruvian, Burgers");
        holder.civTruck.setImageResource(R.drawable.img_placeholder_sm);
        holder.rbRatings.setIsIndicator(true);
        holder.rbRatings.setNumStars(5);
        holder.rbRatings.setStepSize(3);

        holder.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ivFavorite.setImageResource(R.drawable.rating_red);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFood;
        CircleImageView civTruck;
        TextView tvTruckName;
        TextView tvTruckLocation;
        RatingBar rbRatings;
        ImageView ivFavorite;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivFood = itemView.findViewById(R.id.iv_food);
            civTruck = itemView.findViewById(R.id.civ_truck);
            tvTruckName = itemView.findViewById(R.id.tv_truck_name);
            tvTruckLocation = itemView.findViewById(R.id.tv_truck_location);
            rbRatings = itemView.findViewById(R.id.rating_bar_truck);
            ivFavorite = itemView.findViewById(R.id.iv_favorite);
        }

    }

}
