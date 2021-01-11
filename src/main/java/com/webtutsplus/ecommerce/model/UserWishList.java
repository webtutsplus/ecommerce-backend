package com.webtutsplus.ecommerce.model;

import java.util.ArrayList;

public class UserWishList {
    private long userId;
    private long productsId;

    public UserWishList(long userId, long productsId) {
        this.userId = userId;
        this.productsId = productsId;
    }

    public long getProductsId() {
        return productsId;
    }

    public long getUserId() {
        return userId;
    }
}
