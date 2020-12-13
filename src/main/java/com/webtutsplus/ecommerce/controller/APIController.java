package com.webtutsplus.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.services.CategoryService;

@RestController
public class APIController {
	
	@Autowired
	private CategoryService cs;
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @RequestBody Category category) {
		if (cs.readCategory(category.getCategoryName()) != null) {
			return "CATEGORY_ALREADY_EXISTS";
		}
		
		cs.createCategory(category);
		return "SUCCESS";
	}
	
	@PostMapping("/category/read")
	public Category readCategory(@RequestBody long categoryId) {
		return cs.readCategory(categoryId);
	}

}
