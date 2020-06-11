package com.rajabmammadli.rockit.Models;

public class CategoryListModel {

    Integer bgColor;
    String categoryDesc;

    public CategoryListModel(Integer bgColor, String categoryDesc) {
        this.bgColor = bgColor;
        this.categoryDesc = categoryDesc;
    }

    public Integer getBgColor() {
        return bgColor;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }
}
