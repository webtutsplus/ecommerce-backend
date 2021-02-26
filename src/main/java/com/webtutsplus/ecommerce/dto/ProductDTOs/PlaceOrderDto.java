package com.webtutsplus.ecommerce.dto.ProductDTOs;

import com.webtutsplus.ecommerce.model.Order;
import com.webtutsplus.ecommerce.model.Product;

import javax.validation.constraints.NotNull;

public class PlaceOrderDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
    private @NotNull Long productId;


    public PlaceOrderDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public PlaceOrderDto(Order order) {
        this.setId(order.getId());
        this.setUserId(order.getUserId());
        this.setQuantity(order.getQuantity());
        this.setProductId(order.getProductId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
