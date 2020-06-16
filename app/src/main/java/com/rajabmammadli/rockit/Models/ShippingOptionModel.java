package com.rajabmammadli.rockit.Models;

public class ShippingOptionModel {

    String optionDesc;
    String optionPrice;

    public ShippingOptionModel(String optionDesc, String optionPrice) {
        this.optionDesc = optionDesc;
        this.optionPrice = optionPrice;
    }

    public String getOptionDesc() {
        return optionDesc;
    }

    public String getOptionPrice() {
        return optionPrice;
    }
}
