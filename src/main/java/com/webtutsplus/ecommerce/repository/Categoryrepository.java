package com.webtutsplus.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webtutsplus.ecommerce.model.Category;

@Repository
public interface Categoryrepository extends CrudRepository<Category, Long> {
	
	public Category findByCategoryId(long categoryId);
	
	public Category findByCategoryName(String categoryName);
	
}
