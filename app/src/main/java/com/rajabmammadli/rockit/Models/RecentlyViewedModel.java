package com.rajabmammadli.rockit.Models;

public class RecentlyViewedModel {

    Integer recentBgImage;
    String recentProductName;
    String recentStoreName;
    String recentPriceList;

    public RecentlyViewedModel(Integer recentBgImage, String recentProductName, String recentStoreName, String recentPriceList) {
        this.recentBgImage = recentBgImage;
        this.recentProductName = recentProductName;
        this.recentStoreName = recentStoreName;
        this.recentPriceList = recentPriceList;
    }

    public Integer getRecentBgImage() {
        return recentBgImage;
    }

    public String getRecentProductName() {
        return recentProductName;
    }

    public String getRecentStoreName() {
        return recentStoreName;
    }

    public String getRecentPriceList() {
        return recentPriceList;
    }
}
