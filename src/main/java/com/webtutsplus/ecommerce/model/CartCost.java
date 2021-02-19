package com.webtutsplus.ecommerce.model;

import com.webtutsplus.ecommerce.dto.CartDto;

import java.util.List;

public class CartCost {
    private List<CartDto> cartItems;
    private int totalCost;

    public CartCost(List<CartDto> cartDtoList, int totalCost) {
        this.cartItems = cartDtoList;
        this.totalCost = totalCost;
    }

    public List<CartDto> getcartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDto> cartDtoList) {
        this.cartItems = cartDtoList;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
