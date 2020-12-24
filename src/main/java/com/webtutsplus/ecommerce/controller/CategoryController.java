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
	private @Autowired CategoryService categoryService;

	/**
	 * Handles GET requests to /api/category/.
	 * @return Returns a list of all the current categories.
	 */
	@GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
    }

	/**
	 * Handles POST requests to /api/category/create. Function is used to create new Categories.
	 * @param category A valid object of type Category.
	 * @return Returns a response entity generated using ApiResponse object.
	 */
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		// Check to see if the category already exists. If it does then return an error stating that the category
		// already exists.
		if (categoryService.readCategory(category.getCategoryName()).isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}

		// Pass the Category object to the category service to handle adding it to the database.
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}

	/**
	 * Handles POST requests to /api/category/update/<categoryID>.
	 * @param categoryID The ID of the category you wish to update.
	 * @param category The new category object you wish to use.
	 * @return Returns a response entity generated using ApiResponse object.
	 */
	@PostMapping("/update/<categoryID>")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("category") long categoryID, @Valid @RequestBody Category category) {
		// Check to see if the category exists.
		if (categoryService.readCategory(category.getCategoryName()).isPresent()) {
			// If the category exists then update it.
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}
}
