package com.webtutsplus.ecommerce.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.repository.Categoryrepository;

@Service
@Transactional
public class CategoryService {

	private final Categoryrepository cr;
	
	public CategoryService(Categoryrepository cr) {
		this.cr = cr;
	}
	
	public void createCategory(Category category) {
		cr.save(category);
	}
	
	public Category readCategory(long categoryId) {
		return cr.findByCategoryId(categoryId);
	}
	
	public Category readCategory(String categoryName) {
		return cr.findByCategoryName(categoryName); 
	}
	
}
