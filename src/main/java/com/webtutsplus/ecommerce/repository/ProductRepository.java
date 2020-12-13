package com.webtutsplus.ecommerce.repository;

import com.webtutsplus.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
