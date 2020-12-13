package com.webtutsplus.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/")
    public ResponseEntity<List<Category>> getProducts() {
        List<Category> body = cs.listCategories();
        return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
    }
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		if (cs.readCategory(category.getCategoryName()) != null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}
		
		cs.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}
	
	@PostMapping("/read")
	public ResponseEntity<Category> readCategory(@RequestBody long categoryId) {
		Category c = cs.readCategory(categoryId);
		if (c != null)
			return new ResponseEntity<Category>(c, HttpStatus.OK);
		
		return new ResponseEntity<Category>(c, HttpStatus.NOT_FOUND);
	}

}
