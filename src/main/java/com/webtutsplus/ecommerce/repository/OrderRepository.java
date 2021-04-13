package com.webtutsplus.ecommerce.repository;

import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Order;
import com.webtutsplus.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}
