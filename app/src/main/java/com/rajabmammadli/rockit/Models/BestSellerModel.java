package com.rajabmammadli.rockit.Models;

import android.widget.ImageView;

public class BestSellerModel {

    Integer bestSellerProductImage;
    String bestSellerProductName;
    String bestSellerStoreName;
    String bestSellerPriceList;

    public BestSellerModel(Integer bestSellerProductImage, String bestSellerProductName, String bestSellerStoreName, String bestSellerPriceList) {
        this.bestSellerProductImage = bestSellerProductImage;
        this.bestSellerProductName = bestSellerProductName;
        this.bestSellerStoreName = bestSellerStoreName;
        this.bestSellerPriceList = bestSellerPriceList;
    }

    public Integer getBestSellerProductImage() {
        return bestSellerProductImage;
    }

    public String getBestSellerProductName() {
        return bestSellerProductName;
    }

    public String getBestSellerStoreName() {
        return bestSellerStoreName;
    }

    public String getBestSellerPriceList() {
        return bestSellerPriceList;
    }
}
