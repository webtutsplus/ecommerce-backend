package com.webtutsplus.ecommerce.model;


import io.swagger.models.auth.In;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class WishList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private @NotBlank Integer userId;

    @Column(name = "product_id")
    private @NotBlank Integer productId;

    public WishList() {
    }


    public WishList(Integer userId, Integer productId) {
        this.userId = userId;
        this.productId=productId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
