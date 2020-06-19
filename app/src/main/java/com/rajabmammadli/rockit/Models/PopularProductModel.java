package com.rajabmammadli.rockit.Models;

public class PopularProductModel {

    Integer popularProductImage;
    String popularProductName;
    String popularStoreName;
    String popularPriceList;

    public PopularProductModel(Integer popularProductImage, String popularProductName, String popularStoreName, String popularPriceList) {
        this.popularProductImage = popularProductImage;
        this.popularProductName = popularProductName;
        this.popularStoreName = popularStoreName;
        this.popularPriceList = popularPriceList;
    }

    public Integer getPopularProductImage() {
        return popularProductImage;
    }

    public String getPopularProductName() {
        return popularProductName;
    }

    public String getPopularStoreName() {
        return popularStoreName;
    }

    public String getPopularPriceList() {
        return popularPriceList;
    }
}
