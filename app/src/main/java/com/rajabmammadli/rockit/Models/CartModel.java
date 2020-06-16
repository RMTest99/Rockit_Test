package com.rajabmammadli.rockit.Models;

public class CartModel {

    Integer cartProductImage;
    String cartProductName;
    String cartProductSize;
    String cartProductColor;
    String cartProductPrice;

    public CartModel(Integer cartProductImage, String cartProductName, String cartProductSize, String cartProductColor, String cartProductPrice) {
        this.cartProductImage = cartProductImage;
        this.cartProductName = cartProductName;
        this.cartProductSize = cartProductSize;
        this.cartProductColor = cartProductColor;
        this.cartProductPrice = cartProductPrice;
    }

    public Integer getCartProductImage() {
        return cartProductImage;
    }

    public String getCartProductName() {
        return cartProductName;
    }

    public String getCartProductSize() {
        return cartProductSize;
    }

    public String getCartProductColor() {
        return cartProductColor;
    }

    public String getCartProductPrice() {
        return cartProductPrice;
    }
}
