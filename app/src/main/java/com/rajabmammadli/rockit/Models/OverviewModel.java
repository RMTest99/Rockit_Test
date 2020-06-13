package com.rajabmammadli.rockit.Models;

public class OverviewModel {

    Integer overviewProductImage;
    String overviewProductName;
    String overviewStoreName;
    String overviewPriceList;

    public OverviewModel(Integer overviewProductImage, String overviewProductName, String overviewStoreName, String overviewPriceList) {
        this.overviewProductImage = overviewProductImage;
        this.overviewProductName = overviewProductName;
        this.overviewStoreName = overviewStoreName;
        this.overviewPriceList = overviewPriceList;
    }

    public Integer getOverviewProductImage() {
        return overviewProductImage;
    }

    public String getOverviewProductName() {
        return overviewProductName;
    }

    public String getOverviewStoreName() {
        return overviewStoreName;
    }

    public String getOverviewPriceList() {
        return overviewPriceList;
    }
}
