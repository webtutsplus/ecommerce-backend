package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.service.CategoryService;
import com.webtutsplus.ecommerce.service.ProductService;
import com.webtutsplus.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private @Autowired ProductService productService;
    private @Autowired CategoryService categoryService;

    /**
     * Handles GET requests for /api/product/.
     * @return Returns a list of all current products.
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> body = productService.listProducts();
        return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
    }

    /**
     * Handles POST requests for /api/product/add. Its responsible for adding new products.
     * @param productDto It receives a ProductDTO (Product Data Transfer Object) object.
     * @return Returns a Response Entity containing an ApiResponse object.
     */
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        // Check to see if the product has a valid category.
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        // If the product doesn't have a valid category then send back an error message.
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }

        // If it does have a category present then add it to the products.
        Category category = optionalCategory.get();
        // The product model contains a reference to the category model so it is required to save the product to the database.
        productService.addProduct(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    //
    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") long productID, @RequestBody @Valid ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
}
