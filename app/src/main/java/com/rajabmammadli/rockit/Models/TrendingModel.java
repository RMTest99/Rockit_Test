package com.rajabmammadli.rockit.Models;

public class TrendingModel {

    Integer productImage;
    String productName;
    String storeName;
    String priceList;

    public TrendingModel(Integer productImage, String productName, String storeName, String priceList) {
        this.productImage = productImage;
        this.productName = productName;
        this.storeName = storeName;
        this.priceList = priceList;
    }

    public Integer getProductImage() {
        return productImage;
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
