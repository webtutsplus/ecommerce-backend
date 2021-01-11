package com.webtutsplus.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class UserWishList {
    private long userId;
    private List<Long> productsId;

    public UserWishList(long userId, List<Long> productsId) {
        this.userId = userId;
        this.productsId=productsId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public long getUserId() {
        return userId;
    }
}
