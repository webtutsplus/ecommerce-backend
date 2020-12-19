package com.webtutsplus.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.repository.Categoryrepository;

@Service
@Transactional
public class CategoryService {

	private final Categoryrepository categoryrepository;
	
	public CategoryService(Categoryrepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}
	
	public List<Category> listCategories() {
		return categoryrepository.findAll();
	}
	
	public void createCategory(Category category) {
		categoryrepository.save(category);
	}

	public Category readCategory(String categoryName) {
		return categoryrepository.findByCategoryName(categoryName);
	}

	public Optional<Category> readCategory(Long categoryId) {
		return categoryrepository.findById(categoryId);
	}
	
}
