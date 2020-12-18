package com.webtutsplus.ecommerce.service;

import java.util.List;

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
	
	public List<Category> listCategories() {
		return cr.findAll();
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
