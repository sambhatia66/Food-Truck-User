package com.fluper.foodtruckuser.model;

import android.widget.ImageView;

import java.io.Serializable;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 27/3/18.
 */

public class FoodInformation  implements Serializable {
    String truckName;
    String truckLocation;
    String foodImage;
    String truckImage;

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getTruckLocation() {
        return truckLocation;
    }

    public void setTruckLocation(String truckLocation) {
        this.truckLocation = truckLocation;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getTruckImage() {
        return truckImage;
    }

    public void setTruckImage(String truckImage) {
        this.truckImage = truckImage;
    }

    public FoodInformation(String truckName, String truckLocation, String foodImage, String truckImage){
        this.truckName = truckName;
        this.truckLocation = truckLocation;
        this.foodImage = foodImage;
        this.truckImage = truckImage;

    }
}
