package com.webtutsplus.ecommerce.model;


import com.webtutsplus.ecommerce.dto.ProductDTOs.OrderDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.PlaceOrderDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private @NotBlank Integer userId;

    @Column(name = "product_id")
    private @NotBlank Long productId;

    private @NotBlank Integer quantity;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;


    public Order() {
    }

    public Order(PlaceOrderDto orderDto, int userId){
        this.userId = userId;
        this.productId = orderDto.getProductId();
        this.quantity = orderDto.getQuantity();
        this.createdDate = new Date();

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
