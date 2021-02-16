package com.webtutsplus.ecommerce.dto;

import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Product;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Long productId;
    private @NotNull Integer quantity;

    public CartDto() {
    }

    public CartDto(Integer id, @NotNull Integer userId, @NotNull Long productId, @NotNull Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartDto(Cart cart) {
        this.setId(cart.getId());
        this.setProductId(cart.getProductId());
        this.setUserId(cart.getUserId());
        this.setQuantity(cart.getQuantity());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
