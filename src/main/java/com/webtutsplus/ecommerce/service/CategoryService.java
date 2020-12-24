package com.webtutsplus.ecommerce.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import com.webtutsplus.ecommerce.exceptions.CustomException;
import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.repository.Categoryrepository;

@Service
@Transactional
public class CategoryService {
	private final Categoryrepository categoryrepository;

	/**
	 * Pubblic constructor used for code injecting the category repository.
	 */
	public CategoryService(Categoryrepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}

	/**
	 * Retrieves a list of all the categories inside the categories database table.
	 * @return List of categories.
	 */
	public List<Category> listCategories() {
		return categoryrepository.findAll();
	}

	/**
	 * Adds a new category to the categories database.
	 * @param category Category object that you want to add to the database.
	 */
	public void createCategory(Category category) {
		categoryrepository.save(category);
	}

	/**
	 * Looks through the categories database to find an object by its name.
	 * @param categoryName The name of the category you are looking for.
	 * @return Returns an optional Category object. Might be null if there wasn't such a category.
	 */
	public Optional<Category> readCategory(String categoryName) {
		return categoryrepository.findByCategoryName(categoryName);
	}

	/**
	 * Looks through the categories database to find an object by its id.
	 * @param categoryId The ID of the category you are looking for.
	 * @return Returns an optional Category object. Might be null if there wasn't such a category.
	 */
	public Optional<Category> readCategory(Long categoryId) {
		return categoryrepository.findById(categoryId);
	}

	/**
	 * Updates the values of a category that is currently in the database.
	 * @param categoryID The ID of the category.
	 * @param newCategory The new category that you want to add to the database.
	 * @exception NoSuchElementException This function will throw an exception if if can't find the category by it's ID.
	 */
	public void updateCategory(Long categoryID, Category newCategory) throws NoSuchElementException {
		Category category = categoryrepository.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		category.setProducts(newCategory.getProducts());
		category.setImageUrl(newCategory.getImageUrl());

		categoryrepository.save(category);
	}
}
