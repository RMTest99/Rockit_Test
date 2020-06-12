package com.rajabmammadli.rockit.Models;

public class StoreListModel {

    Integer storeImage;
    String storeNames;

    public StoreListModel(Integer storeImage, String storeNames) {
        this.storeImage = storeImage;
        this.storeNames = storeNames;
    }

    public Integer getStoreImage() {
        return storeImage;
    }

    public String getStoreNames() {
        return storeNames;
    }

}
