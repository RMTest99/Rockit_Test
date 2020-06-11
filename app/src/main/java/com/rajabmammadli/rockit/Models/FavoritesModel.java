package com.rajabmammadli.rockit.Models;

public class FavoritesModel {

    Integer productImg;
    String productName;
    String storeName;
    String priceList;

    public FavoritesModel(Integer productImg, String productName, String storeName, String priceList) {
        this.productImg = productImg;
        this.productName = productName;
        this.storeName = storeName;
        this.priceList = priceList;
    }

    public Integer getProductImg() {
        return productImg;
    }

    public String getProductName() {
        return productName;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getPriceList() {
        return priceList;
    }
}
