package com.fluper.foodtruckuser.model;

import java.io.Serializable;

/**
 * Created by fluper on 27/3/18.
 */

//todo no need of setter i hope.. private variables...
public class FoodInformation  implements Serializable {
    String truckName;
    String truckLocation;
    int foodImage;
    int truckImage;

    public FoodInformation(int truckImage, String truckName, int foodImage) {
        this.truckImage =truckImage;
        this.truckName = truckName;
        this.foodImage = foodImage;
    }

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

    public Integer getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Integer foodImage) {
        this.foodImage = foodImage;
    }

    public Integer getTruckImage() {
        return truckImage;
    }

    public void setTruckImage(Integer truckImage) {
        this.truckImage = truckImage;
    }



    }

