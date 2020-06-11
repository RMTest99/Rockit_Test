package com.rajabmammadli.rockit.Models;

public class NewReleaseListModel {

    Integer bgImage;
    String productName;
    String storeName;
    String priceList;

    public NewReleaseListModel(Integer bgImage, String productName, String storeName, String priceList) {
        this.bgImage = bgImage;
        this.productName = productName;
        this.storeName = storeName;
        this.priceList = priceList;
    }

    public Integer getBgImage() {
        return bgImage;
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
