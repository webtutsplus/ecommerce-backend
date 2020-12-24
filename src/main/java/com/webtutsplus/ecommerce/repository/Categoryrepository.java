package com.webtutsplus.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtutsplus.ecommerce.model.Category;

import java.util.Optional;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Long> {

	Optional<Category> findByCategoryName(String categoryName);
	
}
