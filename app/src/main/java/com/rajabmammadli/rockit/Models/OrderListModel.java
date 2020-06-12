package com.rajabmammadli.rockit.Models;

public class OrderListModel {

    Integer orderProductImage;
    String orderProductName;
    String orderDate;

    public OrderListModel(Integer orderProductImage, String orderProductName, String orderDate) {
        this.orderProductImage = orderProductImage;
        this.orderProductName = orderProductName;
        this.orderDate = orderDate;
    }

    public Integer getOrderProductImage() {
        return orderProductImage;
    }

    public String getOrderProductName() {
        return orderProductName;
    }

    public String getOrderDate() {
        return orderDate;
    }
}
