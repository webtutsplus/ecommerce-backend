package com.webtutsplus.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtutsplus.ecommerce.model.Category;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Long> {
	
	Category findByCategoryName(String categoryName);
	
}
