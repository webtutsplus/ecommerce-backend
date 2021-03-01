package com.webtutsplus.ecommerce.dto.ProductDTOs;

import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Order;
import com.webtutsplus.ecommerce.model.Product;

import javax.validation.constraints.NotNull;

public class OrderDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
    private @NotNull Product product;


    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        this.setUserId(order.getUserId());
        this.setQuantity(order.getQuantity());
        this.setProduct(order.getProduct());
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
