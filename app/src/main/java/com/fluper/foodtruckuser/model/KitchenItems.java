package com.fluper.foodtruckuser.model;

/**
 * Created by fluper on 4/4/18.
 */

public class KitchenItems {
    String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public KitchenItems(String itemName) {
        this.itemName = itemName;
    }
}
