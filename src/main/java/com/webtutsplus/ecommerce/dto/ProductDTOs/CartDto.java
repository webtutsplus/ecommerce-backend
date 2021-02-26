package com.webtutsplus.ecommerce.dto.ProductDTOs;

import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Product;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    public CartDto() {
    }

    public CartDto(Cart cart) {
        this.setId(cart.getId());
        this.setUserId(cart.getUserId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", productName=" + product.getName() +
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
