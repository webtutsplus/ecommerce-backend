package com.webtutsplus.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.webtutsplus.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")

public class CategoryController {
	@Autowired private CategoryService categoryService;

	/**
	 * Handles GET requests to /api/category/. Used to get a list of all categories.
	 * @return A list of all categories.
	 */
	@GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
    }

	/**
	 * Handles POST requests to /api/category/create. Used to create a new category.
	 * @param category The category object you want to add.
	 * @return Returns a Response Entity containing an Api Response object.
	 */
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		if (Helper.notNull(categoryService.readCategory(category.getCategoryName()))) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}

	/**
	 * Handles POST requests to /api/update/{categoryID}. Used to update a category.
	 * @param categoryID The ID of the category you want to update.
	 * @param category The new category object that you want to use for the update.
	 * @return Returns a Response Entity containing an Api Response object.
	 */
	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") long categoryID, @Valid @RequestBody Category category) {
		// Check to see if the category exists.
		if (Helper.notNull(categoryService.readCategory(category.getCategoryName()))) {
			// If the category exists then update it.
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Handles DELETE requests to /api/delete/{categoryID}. Used to delete the category from the database.
	 * @param categoryID The ID of the category we want to delete.
	 * @return Returns a Response Entity containing an Api Response object.
	 */
	@DeleteMapping("/delete/{categoryID}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryID") long categoryID) {
		categoryService.deleteCategory(categoryID);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "deleted category"), HttpStatus.OK);
	}
}
