package com.webtutsplus.ecommerce.repository;

import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.User;
import com.webtutsplus.ecommerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);

}

