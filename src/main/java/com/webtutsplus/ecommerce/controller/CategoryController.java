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
	public String createCategory(@Valid @RequestBody Category category) {
		if (cs.readCategory(category.getCategoryName()) != null) {
			return "CATEGORY_ALREADY_EXISTS";
		}
		
		cs.createCategory(category);
		return "SUCCESS";
	}
	
	@PostMapping("/read")
	public Category readCategory(@RequestBody long categoryId) {
		return cs.readCategory(categoryId);
	}

}
